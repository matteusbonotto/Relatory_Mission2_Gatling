//##############################################################################//
//    Script 03//                                                               //
//    Deverão ser feitos 4 scripts para teste, utilizar o package de config com //
//    as informações comuns a todos, os 4 scripts são os seguintes:             //
//  * Realizar pesquisa por macbook, não é necessário estressar ele, usar       //
//    asserts ou feeder                                                         //
//##############################################################################//

//Pacote
package Relatorio_Missao2

//Bibliotecas
import io.devqa.config.config._
import io.gatling.core.scenario._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

//Classe
class GET_Computer extends Simulation {

  //Definição do cenário de teste
  val scn = scenario("Get_Computers")
    .feed(searchFeeder)
    .exec(http("get_computers")
      .get(urlbase + "/#{code}")
      .headers(header_0))

  //Definição do cenario de simulação
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

    //Asserts
    .assertions(
      details("get_computers").successfulRequests.percent.gte(95))

}