package controllers

import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.OFormat.oFormatFromReadsAndOWrites
import play.api.libs.json.{JsValue, Json}

import javax.inject._
import play.api.mvc._
import play.api.libs.ws._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, ws: WSClient) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def savee = Action(parse.json) { request =>
    val content = request.body.as[CreditScoreRequest]

    val cs = cSCards(content.name, content.creditScore).map( res => {
      var listObj = res.as[List[CsCard]]
      listObj.map(card => {
        card.copy(provider = Option("CSCard"), name = Option(card.cardName), cardScore = Option(sortingScore(card.apr, card.eligibility)))
      })
    })

   val sc = scoredCards(content.name, content.creditScore, content.salary).map( res => {
     var listObj = res.as[List[ScoredCard]]
     listObj.map(scard => {
       scard.copy(provider = Option("ScoredCards"), name = Option(scard.card), cardScore = Option(sortingScore(scard.apr, scard.approvalRating)))
     })
   })
    val answer = Await.result(cs, Duration.Inf)
    val answer2 = Await.result(sc, Duration.Inf)

    var response : List[CreditCard] = Json.toJson(answer2).as[List[CreditCard]] ::: Json.toJson(answer).as[List[CreditCard]]
    val sortedResponse = response.sortBy(_.cardScore)
    Ok(Json.toJson(sortedResponse))
  }

  /**
   * The first partner provides a JSON API to get eligible cards.
   * They’re only interested in a users full name and credit score to make their decisions.
   * The response is a list of cards, including an eligibility rating from 0.0 to 10.0.
   *
   * @param name
   * @param creditScore
   * @return Future
   */
  def cSCards(name: String, creditScore: Int):  Future[JsValue] =  {
    val data = Json.obj(
      "name" -> name,
      "creditScore" -> creditScore
    )

    val request = ws.url("https://app.clearscore.com/api/global/backend-tech-test/v1/cards").withRequestTimeout(10000.millis).post(data).map(res => {
     res.json
    })
    request
  }


  /**
   * Our other partner uses all the users information to make their scoring decisions.
   * The eligibility rating is provided in the approvalRating field and is on a scale from 0.0 to 1.0.
   */
  def scoredCards(name: String, creditScore: Int, salary: Double): Future[JsValue] = {

    val data = Json.obj(
      "name" -> name,
      "score" -> creditScore,
      "salary" -> salary
    )
    val request = ws.url ("https://app.clearscore.com/api/global/backend-tech-test/v2/creditcards")

    var response = request.post(data).map( request => {
      request.json
    })

    response
  }

  /**
   * calculates sortingScore
   */
  def sortingScore(apr: Double, eligibility: Double): Double = {
    BigDecimal(eligibility/ (apr * apr)).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

}
