/*
 * Copyright 2019 HM Revenue & Customs
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

package pages.tests

import model.{EnrolmentKeys, Vrn}
import pages.{ErrorPage, InProgress}
import support.{AuthWireMockResponses, DesWireMockResponses, ItSpec}

class InProgressSpec extends ItSpec {

  val vrn = Vrn("234567890")
  val path = s"""/vat-repayment-tracker-frontend/show-results/vrn/${vrn.value}"""

  "user is authorised and financial data found" in {
    setup()
    InProgress.assertPageIsDisplayed(vrn, amount = "£5.56", appender = "_inprogress")
    InProgress.checkGuidance
    InProgress.uniqueToPage
  }

  "user is authorised and financial data found but partial" in {
    setup(true, true)
    InProgress.assertPageIsDisplayed(vrn, amount = "£5.56", partialAccount = true, appender = "_inprogress")
    InProgress.checkGuidance
    InProgress.uniqueToPage
  }

  "click completed link" in {
    setup()
    InProgress.completedLink
  }

  "user is authorised and address data found" in {
    setup(false)
    InProgress.assertPageIsDisplayed(vrn, false, true, amount = "£5.56", appender = "_inprogress")
    InProgress.uniqueToPage
  }

  "Get ShowResults authorised but wrong vrn should show error page" in {
    AuthWireMockResponses.authOkNoEnrolments(wireMockBaseUrlAsString = wireMockBaseUrlAsString)
    goToViaPath(path)
    ErrorPage.assertPageIsDisplayed(vrn)
  }

  "Get ShowResult logged in but wrong VRN" in {
    val vrnOther: Vrn = Vrn("2345678891")
    AuthWireMockResponses.authOkWithEnrolments(wireMockBaseUrlAsString = wireMockBaseUrlAsString, vrn = vrnOther, enrolment = EnrolmentKeys.mtdVatEnrolmentKey)
    goToViaPath(path)
    ErrorPage.assertPageIsDisplayed(vrn)
  }

  "check negative amount" in {
    AuthWireMockResponses.authOkWithEnrolments(wireMockBaseUrlAsString = wireMockBaseUrlAsString, vrn = vrn, enrolment = EnrolmentKeys.mtdVatEnrolmentKey)
    DesWireMockResponses.financialDataSingleOkNegative(vrn)
    DesWireMockResponses.customerDataOkWithBankDetails(vrn)
    DesWireMockResponses.repaymentDetailSingleInProgress(vrn)
    goToViaPath(path)
    InProgress.assertPageIsDisplayed(vrn, amount = "£5.56", appender = "_inprogress")
  }

  "multiple inprogress " in {
    setup(true, true, false)
    InProgress.uniqueToPage
    InProgress.completedLink
  }

  private def setup(useBankDetails: Boolean = true, partialBankDetails: Boolean = false, singleRepayment: Boolean = true) = {
    AuthWireMockResponses.authOkWithEnrolments(wireMockBaseUrlAsString = wireMockBaseUrlAsString, vrn = vrn, enrolment = EnrolmentKeys.mtdVatEnrolmentKey)
    if (singleRepayment)
      DesWireMockResponses.financialsOkSingle(vrn)
    else
      DesWireMockResponses.financialsOkMultiple4(vrn)
    if (useBankDetails) {
      if (partialBankDetails)
        DesWireMockResponses.customerDataOkWithPartialBankDetails(vrn)
      else
        DesWireMockResponses.customerDataOkWithBankDetails(vrn)
    } else {
      DesWireMockResponses.customerDataOkWithoutBankDetails(vrn)
    }
    if (singleRepayment)
      DesWireMockResponses.repaymentDetailSingleInProgress(vrn)
    else
      DesWireMockResponses.repaymentDetailsMultipleInProgress(vrn)
    goToViaPath(path)
  }

}