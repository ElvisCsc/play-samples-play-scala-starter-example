package controllers

import play.api.libs.json.{Json, OFormat}

case class CreditScoreRequest ( name: String, creditScore: Int, salary: Double)

object CreditScoreRequest {
  implicit val format: OFormat[CreditScoreRequest] = Json.format[CreditScoreRequest]
}