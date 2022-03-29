package controllers

import play.api.libs.json.{Json, OFormat}

case class ScoredCard(provider: String = "ScoredCards", name: Option[String] = Option(""), apr: String, cardScore: Option[Double] = Option(0),
                      card: Option[String] = Option(""), approvalRating: Double)

object ScoredCard {
  implicit val format: OFormat[ScoredCard] = Json.format[ScoredCard]
}
