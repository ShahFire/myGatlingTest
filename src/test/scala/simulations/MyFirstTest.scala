package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MyFirstTest extends Simulation {

  // 1 Http Conf (конфигурация Http)
  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")
    .proxy(Proxy("localhost", 8888))

  // 2 Scenario Definition (определение сценария)
  val scn = scenario("My First Test")
    .exec(http("Get All Games")
      .get("videogames"))

  // 3 Load Scenario (сценарий нагрузки)
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}