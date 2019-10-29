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

package pages

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Assertion
import pages.Completed.idPresent

object InProgress extends CommonDetail {

  def uniqueToPage(implicit wd: WebDriver): Assertion = {
    readTitle shouldBe "We are processing your VAT repayments"
    readMainMessage shouldBe "We are processing your VAT repayments"
  }

  def checkGuidance(implicit wd: WebDriver): Assertion = {
    whenpay shouldBe "When we will repay you"
    whenpay_desc shouldBe "We will usually repay you within 30 days of HMRC receiving your VAT Return. If you need to speak to someone about your repayment, only contact HMRC after 30 days have passed."
  }

  def noRepayments(implicit webDriver: WebDriver): String = probing(_.findElement(By.id("no-repayments")).getText)
  def whenpay(implicit webDriver: WebDriver): String = probing(_.findElement(By.id("whenpay")).getText)
  def whenpay_desc(implicit webDriver: WebDriver): String = probing(_.findElement(By.id("whenpay-desc")).getText)

  def completedLink(implicit wd: WebDriver): Assertion = {
    clickCompleted
    noRepayments shouldBe "You have no completed repayments"
  }

  def checktabs(implicit wd: WebDriver): Assertion = {
    idPresent("completed-exist") shouldBe false
    idPresent("inprogress-exist") shouldBe true
    idPresent("completed-none") shouldBe true
    idPresent("inprogress-none") shouldBe false
  }

}
