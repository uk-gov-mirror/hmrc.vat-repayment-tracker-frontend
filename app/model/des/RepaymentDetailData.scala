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

package model.des

import java.time.LocalDate

import play.api.libs.json.{Json, OFormat}

final case class RepaymentDetailData(
    returnCreationDate:     LocalDate,
    sentForRiskingDate:     Option[LocalDate],
    lastUpdateReceivedDate: Option[LocalDate],
    periodKey:              String,
    riskingStatus:          String,
    vatToPay_BOX5:          BigDecimal,
    supplementDelayDays:    Option[Int],
    originalPostingAmount:  BigDecimal
) {
  //For a status of initial or sent_for_risking , we might not have a  lastUpdateReceived date
  val sorted: Int = {
    riskingStatus match {
      case INITIAL.value          => 3
      case SENT_FOR_RISKING.value => 2
      case CLAIM_QUERIED.value    => 2
      case _                      => 1
    }
  }
}

object RepaymentDetailData {
  implicit val format: OFormat[RepaymentDetailData] = Json.format[RepaymentDetailData]
}

