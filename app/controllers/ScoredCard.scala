package controllers

import play.api.libs.json.{Json, OFormat}

case class ScoredCard(provider: Option[String] = Option("ScoredCards"), name: Option[String] = Option(""), apr: Double, cardScore: Option[Double] = Option(0),
                      card: String, approvalRating: Double)

object ScoredCard {
  implicit val format: OFormat[ScoredCard] = Json.format[ScoredCard]
}
