package io.devqa.config
//Bibliotecas
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object config {
  //Declaração do URL base
  val httpProtocol = http
    .baseUrl("http://computer-database.gatling.io")

  val urlbase = "http://computer-database.gatling.io/computers"

  //feeders
  val searchFeeder = csv("import.csv").circular

  //Declaração do Header
  val header_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "pt-BR,pt;q=0.9"
  )

}
