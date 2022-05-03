//##############################################################################//
//    Script 04                                                                 //
//    Deverão ser feitos 4 scripts para teste, utilizar o package de config com //
//    as informações comuns a todos, os 4 scripts são os seguintes:             //
//  * Adicionar computadores a página, deverá ser utilizado um feeder do tipo   //
//    csv, essa lista deve conter os 4 parâmetros enviados e 10 itens na lista, //
//    deve ser utilizado para estressar 1 usuário por 10 segundos, esse script  //
//    deve possuir um assert que garanta que mais de 95% das requisições        //
//    passaram e que o tempo máximo de resposta de requisição foi de 5 segundos //
//##############################################################################//

//Pacote
package Relatorio_Missao2

//Bibliotecas
import io.devqa.config.config._
import io.gatling.core.scenario._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

//Classe
class POST_Computer extends Simulation {

  //Definição do cenário de teste
  val scn = scenario("POST_Computers")
    .feed(searchFeeder) //Localizado em io.devqa.Relatorio_Missao2.package
    .exec(http("post_computers")
      .post(urlbase) //Como a página é de teste, para editar um computador é necessário passar os parâmetros do forms, então neste caso usei o método post
      .formParam("""name""", """#{name}""")
      .formParam("""introduced""", """#{introduced}""")
      .formParam("""discontinued""", """#{discontinued}""")
      .formParam("""company""", """#{company}""")
      .headers(header_0))

  //Definição do cenario de simulação
  setUp(
    scn.inject(constantUsersPerSec(1).during(10.seconds)))

    //Asserts
    .assertions(
      details("post_computers").successfulRequests.percent.gte(95),
      details("post_computers").responseTime.max.is(5000))



}
