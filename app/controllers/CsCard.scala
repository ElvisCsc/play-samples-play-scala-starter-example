package controllers

import play.api.libs.json.{Json, OFormat}

case class CsCard (provider: String = "CSCard", apr: Double, cardName: String, eligibility: Double, cardScore: Option[Double] = Option(0))

object CsCard {
  implicit val format: OFormat[CsCard] = Json.format[CsCard]
}