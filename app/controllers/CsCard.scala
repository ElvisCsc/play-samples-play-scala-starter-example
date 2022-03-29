package controllers

import play.api.libs.json.{Json, OFormat}

case class CsCard (provider: Option[String] = Option("CSCard"), name: Option[String] = Option(""), apr: Double, cardScore: Option[Double] = Option(0),
                   cardName: String, eligibility: Double)

object CsCard {
  implicit val format: OFormat[CsCard] = Json.format[CsCard]
}