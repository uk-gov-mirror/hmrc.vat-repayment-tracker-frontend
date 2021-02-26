/*
 * Copyright 2021 HM Revenue & Customs
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

package langswitch

import model.des.BankDetails
import play.api.mvc.Request
import req.RequestSupport

object LangMessages {

  val exapmleMessage: Message = Message(
    english = "Example message",
    welsh   = "Neges enghreifftiol"
  )

  val `We are processing your VAT repayments`: Message = Message(
    english = "We are processing your VAT repayments"
  )

  val `Amount claimed`: Message = Message(
    english = "Amount claimed"
  )

  val `Received on`: Message = Message(
    english = "Received on"
  )

  val `Accounting period`: Message = Message(
    english = "Accounting period"
  )

  val `Accounting period progress hidden`: Message = Message(
    english = "View progress for accounting period"
  )

  val `Accounting period history hidden`: Message = Message(
    english = "View history for accounting period"
  )

  val `When we will repay you`: Message = Message(
    english = "When we will repay you"
  )

  val `When we will repay you description`: Message = Message(
    english = "We will usually repay you within 30 days of HMRC receiving your VAT Return. If you need to speak to someone about your repayment, only "
  )
  val `after 30 days have passed.`: Message = Message(
    english = " after 30 days have passed."
  )

  val `No VAT repayments in progress`: Message = Message(
    english = "No VAT repayments in progress"
  )

  val `Repayments usually take 24 hours`: Message = Message(
    english = "Repayments usually take around 24 hours to show on this page after submitting your VAT Return."
  )

  val `Check this page when you are next expecting a repayment.`: Message = Message(
    english = "Check this page when you are next expecting a repayment."
  )

  val `View your VAT account`: Message = Message(
    english = "View your VAT account"
  )

  val `You are currently paid by bank transfer`: Message = Message(
    english = "You are currently paid by bank transfer to the following account:"
  )

  val `Name on account`: Message = Message(
    english = "Name on account:"
  )

  val `Sort code`: Message = Message(
    english = "Sort code:"
  )

  val `Account number`: Message = Message(
    english = "Account number:"
  )

  val `Manage your repayment bank account`: Message = Message(
    english = "Manage your repayment bank account"
  )

  val `Change account details`: Message = Message(
    english = "Change account details"
  )

  val `Your repayment bank details`: Message = Message(
    english = "Your repayment bank details"
  )

  val `Your repayment details`: Message = Message(
    english = "Your repayment details"
  )

  val `Track your VAT repayments`: Message = Message(
    english = "Track your VAT repayments"
  )

  val `Sent to this account`: Message = Message(
    english = "Your VAT repayments will be sent to this account"
  )

  val `View your business details to update your repayment bank account`: Message = Message(
    english = "View your business details to update your repayment bank account"
  )

  val `Contact HMRC`: Message = Message(
    english = "contact HMRC"
  )

  val `In progress`: Message = Message(
    english = "In progress"
  )

  val `Repayment suspended` = Message(
    english = "Repayment suspended"
  )

  val `Your repayment is suspended` = Message(
    english = "Your repayment is suspended."
  )

  val `Action required` = Message(
    english = "Action required"
  )

  val `You must submit your latest VAT return` = Message(
    english = "You must submit your latest VAT return"
  )

  val `submit your latest VAT return` = Message(
    english = "You must <a href=\"https://www.gov.uk/vat-returns/send-your-return\">submit your latest VAT return</a>"
  )

  val `Submit VAT return` = Message(
    english = "Submit VAT return"
  )

  val `Submit your return` = Message(
    english = "<a href=\"https://www.gov.uk/vat-returns/send-your-return\">Submit your return</a>"
  )

  val `We cannot process your repayment` = Message(
    english = "We cannot process your repayment until you submit your VAT return for the last accounting period.<br /><br /><a href=\"https://www.gov.uk/vat-returns/send-your-return\">Submit your return</a>"
  )

  val `Currently sent to`: Message = Message(
    english = "We'll send your cheque to:"
  )

  val `For faster payment next time`: Message = Message(
    english = "For faster payment next time"
  )

  val `add a repayment bank account`: Message = Message(
    english = "add a repayment bank account"
  )

  val `Update your business address`: Message = Message(
    english = "Update your business address"
  )

  val `Manage or track`: Message = Message(
    english = "Manage Direct Debit and repayment bank account or track repayments"
  )

  val `Manage or track shuttered`: Message = Message(
    english = "Manage Direct Debit and repayment bank account"
  )

  val heading_bta: Message = Message(
    english = "Business tax account"
  )

  val Continue: Message = Message(
    english = "Continue"
  )
  val `View what HMRC owe you`: Message = Message(
    english = "View what HMRC owe you"
  )
  val `There is a problem`: Message = Message(
    "There is a problem"
  )

  def accountAndSortCode(bankDetails: BankDetails): Message = Message(
    s"""Account: ${bankDetails.obscureBankAccountNumber}, Sort code: ${bankDetails.formatSortCode}"""
  )

  val `Manage your Direct Debit`: Message = Message(
    "Manage your Direct Debit"
  )

  val `Set up a Direct Debit`: Message = Message(
    "Set up a Direct Debit"
  )

  val `HMRC will automatically`: Message = Message(
    "HMRC will automatically collect your VAT Return payments when due"
  )

  val `Set up a repayment bank account`: Message = Message("Set up a repayment bank account")

  val `Tell HMRC where to pay your money`: Message = Message("Tell HMRC where to pay your money")

  val `View progress`: Message = Message("View progress")

  val `View history`: Message = Message("View history")

  val `Completed`: Message = Message("Completed")

  val `No completed repayments content here`: Message = Message("No completed repayments content here")

  val `No in progress repayments content here`: Message = Message("No in progress repayments content here")

  val `Your repayment is being processed`: Message = Message("Your repayment is being processed")

  val `Your repayment is delayed`: Message = Message("Your repayment is delayed")

  val `VAT Return received on`: Message = Message(
    english = "VAT Return received on"
  )

  val `Estimated repayment date`: Message = Message(
    english = "Estimated repayment date"
  )

  val `Your repayment progress`: Message = Message("Your repayment progress")

  val `Your repayment history`: Message = Message("Your repayment history")

  val `You must now pay some VAT`: Message = Message("You most now pay some VAT")

  val `Your repayment is complete`: Message = Message("Your repayment is complete")

  val `Checking amount`: Message = Message("Checking amount")

  val `We received your return`: Message = Message("We received your return and are now checking the repayment amount we owe you.")

  val `Repayment amount changed`: Message = Message("Repayment amount changed")

  def `You claimed a VAT repayment of`(originalPostingAmount: String, vatToPay_Box5: String, url: String): Message = Message(s"You claimed £$originalPostingAmount. We calculated this amount was incorrect so we will repay you £$vatToPay_Box5.  This will reach your repayment bank account in 3 working days.  We sent you a letter explaining why we changed your amount. </p><p>If you do not receive a letter in the next 7 days, check your <a href=$url>VAT payments history</a>.")

  val `Sending for further checks`: Message = Message("Sending for further checks")

  val `Repayment approved`: Message = Message("Repayment approved")

  val `VAT payment due`: Message = Message("VAT payment due")

  def `We calculated that the original amount you claimed of`(originalPostingAmount: String, vatToPay_Box5: String): Message = Message(s"""We calculated that the original amount of £$originalPostingAmount you claimed was incorrect. You now owe HMRC £$vatToPay_Box5. We sent you a letter with the reason for this change.""")

  val `Estimated repayment date has passed`: Message = Message("Estimated repayment date has passed")

  val `You do not need to do anything right now`: Message = Message("""You do not need to do anything right now. We are working on repaying you as soon as possible. </p><p>We have sent you a letter to explain that your repayment is delayed.""")

  val `Repayment complete`: Message = Message("Repayment complete")

  val `Your repayment has been approved`: Message = Message("Your repayment has been approved")

  val `We are making sure we pay you the right amount`: Message = Message("We are making sure we pay you the right amount. You do not need to do anything, but we may contact you if we need any further information.")

  val period_1: Message = Message("1 January to 31 March")
  val period_2: Message = Message("1 April to 30 June")
  val period_3: Message = Message("1 July to 30 September")
  val period_4: Message = Message("1 October to 31 December")

  val January: Message = Message("1 January to 31 January")
  val February: Message = Message("1 February to 28 February")
  val February_leap: Message = Message("1 February to 29 February")
  val March: Message = Message("1 March to 31 March")
  val April: Message = Message("1 April to 30 April")
  val May: Message = Message("1 May to 31 May")
  val June: Message = Message("1 June to 30 June")
  val July: Message = Message("1 July to 31 July")
  val August: Message = Message("1 August to 31 August")
  val September: Message = Message("1 September to 30 September")
  val October: Message = Message("1 October to 31 October")
  val November: Message = Message("1 November to 30 November")
  val December: Message = Message("1 December to 31 December")

  val JanToDec: Message = Message("January to December")
  val FebToJan: Message = Message("February to January")
  val MarToFeb: Message = Message("March to February")
  val AprToMar: Message = Message("April to March")
  val MayToApr: Message = Message("May to April")
  val JunToMay: Message = Message("June to May")
  val JulToJun: Message = Message("July to June")
  val AugToJul: Message = Message("August to July")
  val SepToAug: Message = Message("September to August")
  val OctToSep: Message = Message("October to September")
  val NovToOct: Message = Message("November to October")
  val DecToNov: Message = Message("December to November")

  val JanuaryQuarter: Message = Message("1 November to 31 January")
  val FebruaryQuarter: Message = Message("1 December to 28 February")
  val FebruaryQuarter_leap: Message = Message("1 December to 29 February")
  val MarchQuarter: Message = Message("1 January to 31 March")
  val AprilQuarter: Message = Message("1 February to 30 April")
  val MayQuarter: Message = Message("1 March to 31 May")
  val JuneQuarter: Message = Message("1 April to 30 June")
  val JulyQuarter: Message = Message("1 May to 31 July")
  val AugustQuarter: Message = Message("1 June to 31 August")
  val SeptemberQuarter: Message = Message("1 July to 30 September")
  val OctoberQuarter: Message = Message("1 August to 31 October")
  val NovemberQuarter: Message = Message("1 September to 30 November")
  val DecemberQuarter: Message = Message("1 October to 31 December")

  val `We will send this to your repayment bank account`: Message = Message("This will reach your repayment bank account in 3 workings days.")

  def `We will send a cheque to your business address`(url: String): Message = Message(s"We will send a cheque to your business address. This will reach you in 5 to 6 working days. We sent you a letter explaining why we changed your amount.  </p><p>If you do not receive a letter in the next few days, check your <a href=$url>VAT payments history</a>.")

  def `You claimed a VAT repayment of post`(originalPostingAmount: String, vatToPay_Box5: String, url: String): Message = Message(s"You claimed £$originalPostingAmount. We calculated this amount was incorrect so we will repay you £$vatToPay_Box5.  We will send a cheque to your business address. This will reach you in 5 to 6 working days. We sent you a letter explaining why we changed your amount. </p><p>If you do not receive a letter in the next 7 days, check your <a href=$url>VAT payments history</a>.")

  def `repayment-complete-bank-details`(name: String, number: String, sortCode: String, amount: String): Message =
    Message(s"""We sent a payment of £$amount to your repayment bank account:</p><p>Name: $name</p><p>Account number: $number</p><p>Sort code: $sortCode.""")

  def `repayment-complete-address`(address: String, amount: String): Message = Message(s"""We sent a payment of £$amount as a cheque to </p><p> $address.""")

  def `repayment-complete-bank-details-adjusted`(name: String, number: String, sortCode: String, amount: String): Message =
    Message(s"""We sent an adjusted payment of £$amount to your repayment bank account:</p><p>Name: $name</p><p>Account number: $number</p><p>Sort code: $sortCode.""")

  def `repayment-complete-address-adjusted`(address: String, amount: String): Message = Message(s"""We sent you an adjusted payment of £$amount as a cheque to </p><p> $address.""")

  val addressNotAvailable: Message = Message("Address not available")

  val `You now owe HMRC`: Message = Message("You now owe HMRC")

  val `We received your VAT payment`: Message = Message(s"""We received your VAT payment.""")

  val `Amount you claimed`: Message = Message("Amount you claimed")

  val `Amount we'll pay you`: Message = Message("Amount we'll pay you")

  val `Amount to pay`: Message = Message("Amount to pay")

  val `Amount we paid you`: Message = Message("Amount we paid you")

  val `Amount you paid`: Message = Message("Amount you paid")

  val `You need to make a VAT payment`: Message = Message("You need to make a VAT payment")

  val `You have no completed repayments`: Message = Message("You have no completed repayments")

  val `No repayments in progress`: Message = Message("No repayments in progress")

  val `no-in-progress-desc`: Message = Message("""If you are expecting a repayment and it is not showing here, check this page again in 24 hours.</p><p>If you submitted your return early check this page after your accounting period has ended.""")

  def `no-completed-desc`(url: String): Message = Message(s"""Completed repayments will only show here for 60 days after your repayment date. View your <a href="$url">VAT payments history.</a>""")

  val `Your VAT account`: Message = Message("Your VAT account")

  val Back: Message = Message("Back")

  val `View payments history`: Message = Message("View payments history")

  val `Pay now`: Message = Message("Pay now")

  val `Payment and repayments`: Message = Message("Payment and repayments")

  val `You cannot access this service`: Message = Message("You cannot access this service")

  val `non-mtd-line1`: Message = Message("You have not signed up to Making Tax Digital for VAT.  You need to this before you can track your VAT repayments.")

  def `non-mtd-line2`(url: String): Message = Message(s"""Find out how to <a href="$url" target="_blank">sign up for Making Tax Digital for VAT (opens in a new window or tab).</a>""")

  def `non-mtd-line3`(url: String): Message = Message(s"""View your <a href="$url">Business Tax Account.""")

  val shuttered: Message = Message(english = "This service is shuttered")

  object timeoutDialog {
    def message(implicit request: Request[_]) = if (RequestSupport.isLoggedIn)
      Message(english = "For your security, we will sign you out in")
    else
      Message(english = "For your security, we will time you out in")

    def keepAlive(implicit request: Request[_]) = if (RequestSupport.isLoggedIn)
      Message(english = "Stay signed in")
    else
      Message(english = "Continue")

    def signOut(implicit request: Request[_]) = if (RequestSupport.isLoggedIn)
      Message(english = "Sign out")
    else
      Message(english = "Delete your answers")
  }

  val `For your security, we signed you out` = Message(english = "For your security, we signed you out")
  val `We did not save your answers` = Message(english = "We did not save your answers.")
}

