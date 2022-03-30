import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.libs.json.{JsValue, Json}

/**
 * Functional tests start a Play application internally, available
 * as `app`.
 */
class FunctionalSpec extends PlaySpec with GuiceOneAppPerSuite {

  "Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    // Http 415 Unsupported Media type error with JSON
    "send 200 on a good request" in  {
      route(app, FakeRequest(GET, "/creditcards")).map(status(_)) mustBe Some(415)
    }

  }

  "HomeController" should {

    "can parse a JSON body" in {
      val home = route(app, FakeRequest(GET, "/creditcards").withBody(Json.parse("""{ "name": "Elvis Sebatane", "creditScore":656, "salary": 18000 }"""))).get

      status(home) mustBe Status.OK
      contentType(home) mustBe Some("application/json")
    }

  }
}
