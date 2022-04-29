//##############################################################################//
//    Script 01//                                                               //
//    Deverão ser feitos 4 scripts para teste, utilizar o package de config com //
//    as informações comuns a todos, os 4 scripts são os seguintes:             //
//  * Selecionar um computador da lista e deletar ele, não é necessário         //
//    estressar ele, usar asserts ou feeder                                     //
//##############################################################################//

//Pacote
package Relatorio_Missao2

//Bibliotecas
import io.devqa.config.config._
import io.gatling.core.scenario._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

//Classe
class DELETE_Computer extends Simulation {

  //Definição do cenário de teste
  val scn = scenario("Delete_Computers")
      .feed(searchFeeder)
      .exec(http("delete_computers")
      .post(urlbase + "/#{code}" + "/delete") //Como a página é de teste, para deletar um computador é necessário passar o parâmetro na url, então neste caso usei o método post
      .headers(header_0))

  //Definição do cenario de simulação
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

    //Asserts
  .assertions(
    details("delete_computers").successfulRequests.percent.gte(95))

}