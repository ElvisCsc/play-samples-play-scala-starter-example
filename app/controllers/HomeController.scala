package controllers



import play.api.libs.json.JsValue.jsValueToJsLookup
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
  def index = Action {
    var pp = Json.arr("""[{"approvalRating":0.8,"apr":19.4,"card":"ScoredCard Builder"}]""")

    Ok(pp)
  }

  def savee = Action(parse.json) { request =>
    val content = request.body.as[CreditScoreRequest]

    var myList: List[CreditScoreRequest] = List()
    myList = myList :+ content

    var response = Json.toJson(myList)


    val cs = cSCards(content.name, content.creditScore).map( res => {
      var listObj = res.as[List[CsCard]]
      println(listObj)
      listObj.map(card => {
        card.copy(name = Option(card.cardName), cardScore = Option(sortingScore(card.apr, card.eligibility)))
      })
    })


   val sc = scoredCards(content.name, content.creditScore, content.salary).map( res => {

   })
   var answer = Await.result(cs, Duration.Inf)

    println("dhfshgsiogoijio")
    // A1 :: A2
    println(answer)
    Ok(Json.toJson(answer))
  }

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

  def sortingScore(apr: Double, eligibility: Double): Double = {
    BigDecimal(eligibility/ (apr * apr)).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

}


/*
      val hello = Action.async(parse.anyContent) { request =>
ws.url(request.getQueryString("url").get).get().map { r =>
  if (r.status == 200) Ok("The website is up") else NotFound("The website is down")
}
}
   */

/*
    import scala.concurrent.duration._
import play.api.libs.concurrent.Futures._

def index = Action.async {
  // You will need an implicit Futures for withTimeout() -- you usually get
  // that by injecting it into your controller's constructor
  intensiveComputation()
    .withTimeout(1.seconds)
    .map { i =>
      Ok("Got result: " + i)
    }
    .recover {
      case e: scala.concurrent.TimeoutException =>
        InternalServerError("timeout")
    }
}
 */