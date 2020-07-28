package knolx.example

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import com.typesafe.config._

class Simulations extends Simulation {

 val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0")
    .silentUri(".*categoryId=FISH")




  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get("/actions/Catalog.action"))
    .pause(1)
    .exec(http("request_1")
      .get("/actions/Catalog.action?viewCategory=&categoryId=FISH"))
    .pause(1)
    .exec(http("request_2")
      .get("/actions/Catalog.action?viewProduct=&productId=FI-SW-01"))
    .pause(2)
    .exec(http("request_3")
      .get("/actions/Catalog.action?viewCategory=&categoryId=DOGS"))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}

