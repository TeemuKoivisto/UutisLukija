/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.openqa.selenium.By;

public class IndexTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Uutislukija");
  }
  
  @Test
  public void testSuosituinLinkkiToimii() {
      goTo("http://localhost:4567/");
      webDriver.findElement(By.partialLinkText("suosituin")).click();
      String URL = webDriver.getCurrentUrl();
      Assert.assertEquals("http://localhost:4567/suosituin", URL);
  }
  
  @Test
  public void testViimeisinLinkkiToimii() {
      goTo("http://localhost:4567/");
      webDriver.findElement(By.partialLinkText("viimeisin")).click();
      String URL = webDriver.getCurrentUrl();
      Assert.assertEquals("http://localhost:4567/viimeisin", URL);
  }
}