/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import config.ViewConfig
import connectors._
import controllers.action.{Actions, AuthenticatedRequest}
import javax.inject.{Inject, Singleton}
import model._
import play.api.Logger
import play.api.mvc.{Action, _}
import req.RequestSupport
import service.VrtService
import views.Views

import scala.concurrent.ExecutionContext

@Singleton
class BankAccountCocController @Inject() (
    cc:                            ControllerComponents,
    views:                         Views,
    requestSupport:                RequestSupport,
    actions:                       Actions,
    viewConfig:                    ViewConfig,
    bankAccountCocConnector:       BankAccountCocConnector,
    paymentsOrchestratorConnector: PaymentsOrchestratorConnector,
    auditor:                       Auditor,
    vrtService:                    VrtService
)(
    implicit
    ec: ExecutionContext)

  extends FrontendBaseController(cc) {

  def startBankAccountCocJourney(returnPage: ReturnPage, audit: Boolean): Action[AnyContent] =
    actions.securedActionMtdVrnCheckWithoutShutterCheck.async { implicit request: AuthenticatedRequest[_] =>

      if (audit) {
        Logger.debug("startBankAccountCocJourney... trying to audit")
        val repaymentDetailsF = paymentsOrchestratorConnector.getRepaymentsDetails(request.typedVrn.vrn)
        val financialDataF = paymentsOrchestratorConnector.getFinancialData(request.typedVrn.vrn)

        for {
          repaymentDetails <- repaymentDetailsF
          financialData <- financialDataF
          allRepayments = vrtService.getAllRepaymentData(repaymentDetails, request.typedVrn.vrn, financialData)
          _ <- auditor.audit(allRepayments.inProgressRepaymentData, "initiateChangeVATRepaymentBankAccount", "initiate-change-vat-repayment-bank-account")
          nextUrl <- bankAccountCocConnector.startJourney(request.typedVrn.vrn, returnPage)
        } yield {
          Redirect(nextUrl.nextUrl)
        }
      } else {
        Logger.debug("startBankAccountCocJourney... will not audit")
        for {
          nextUrl <- bankAccountCocConnector.startJourney(request.typedVrn.vrn, returnPage)
        } yield Redirect(nextUrl.nextUrl)
      }

    }

}