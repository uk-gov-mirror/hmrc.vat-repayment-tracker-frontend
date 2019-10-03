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
import pages.{ManageOrTrack, OneRepayment}
import support.{AuthWireMockResponses, DesWireMockResponses, ItSpec}

class ManageOrTrackSpec extends ItSpec {

  val vrn = Vrn("234567890")
  val path = s"""/vat-repayment-tracker-frontend/manage-or-track/vrn/${vrn.value}"""

  "user is authorised, bank dd option, manage bank option " in {
    setup(true, true)
    ManageOrTrack.assertPageIsDisplayed(vrn, true, true)
  }

  "user is authorised, manage dd option " in {
    setup(false, true)
    ManageOrTrack.assertPageIsDisplayed(vrn, true, false)
  }

  "user is authorised, manage bank option " in {
    setup(true, false)
    ManageOrTrack.assertPageIsDisplayed(vrn, false, true)
  }

  "click vrtLabel" in {
    setup(true, true)
    ManageOrTrack.clickVrtLabel()
    ManageOrTrack.clickContinue()
    OneRepayment.assertPageIsDisplayed(vrn)
  }

  private def setup(useBankDetails: Boolean = true, useDdDetails: Boolean = true) = {
    AuthWireMockResponses.authOkWithEnrolments(wireMockBaseUrlAsString = wireMockBaseUrlAsString, vrn = vrn, enrolment = EnrolmentKeys.mtdVatEnrolmentKey)
    DesWireMockResponses.financialsOkSingle(vrn)
    if (useBankDetails)
      DesWireMockResponses.customerDataOkWithBankDetails(vrn)
    else
      DesWireMockResponses.customerDataOkWithoutBankDetails(vrn)

    //Show dd radio button
    if (useDdDetails)
      DesWireMockResponses.ddOk(vrn)
    else
      DesWireMockResponses.ddNotFound(vrn)

    goToViaPath(path)
  }

}