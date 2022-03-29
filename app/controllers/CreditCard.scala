package controllers

import play.api.libs.json.{Json, OFormat}

case class CreditCard(provider:String, name:String, apr: Double, cardScore:Double = 0)

object CreditCard {
  implicit val format: OFormat[CreditCard] = Json.format[CreditCard]
}