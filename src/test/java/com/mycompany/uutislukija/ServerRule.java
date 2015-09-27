/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {

  @Override
  protected void before() {
      String[] args = {};
      Main.main(args);
      Main.logiikka = new Logic();
      Main.logiikka.setHackerNews(new MockHackerPaivanUutiset());
   }

  @Override
  protected void after() {
      Spark.stop();
  }
}
