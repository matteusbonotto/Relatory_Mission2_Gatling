//##############################################################################//
//    Script 02//                                                               //
//    Deverão ser feitos 4 scripts para teste, utilizar o package de config com //
//    as informações comuns a todos, os 4 scripts são os seguintes:             //
//  * Selecionar um computador da lista e editar os dados dele, não é necessário//
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
class PUT_Computer extends Simulation {

  //Definição do cenário de teste
  val scn = scenario("PUT_Computers")
    .feed(searchFeeder) //Localizado em io.devqa.Relatorio_Missao2.package
    .exec(http("put_computers")
      .post(urlbase) //Como a página é de teste, para editar um computador é necessário passar os parâmetros do forms, então neste caso usei o método post
      .formParam("""name""", """#{name}""")
      .formParam("""introduced""", """#{introduced}""")
      .formParam("""discontinued""", """#{discontinued}""")
      .formParam("""company""", """#{company}""")
      .headers(header_0))

  //Definição do cenario de simulação
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

    //Asserts
    .assertions(
      details("put_computers").successfulRequests.percent.gte(95))

}