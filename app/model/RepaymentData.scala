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

package model

import java.time.format.DateTimeFormatter
import java.time.{Clock, LocalDate}

final case class RepaymentData(
    returnedReceivedOn: LocalDate,
    period:             String,
    amount:             BigDecimal) {

  def estimatedRepaymentDate: LocalDate = {
    returnedReceivedOn.plusDays(30)
  }

  def isOverdue(implicit clock: Clock): Boolean = {
    estimatedRepaymentDate.isBefore(LocalDate.now(clock))
  }

  def formatDate(localDate: LocalDate): String = {
    val pattern1 = DateTimeFormatter.ofPattern("dd MMM yyyy")
    localDate.format(pattern1)
  }

}