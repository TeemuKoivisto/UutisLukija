/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import static org.assertj.core.api.Assertions.assertThat;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author teemu
 */
public class KaikkiSivutTest extends FluentTest {

    public WebDriver webDriver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @ClassRule
    public static ServerRule server = new ServerRule();

    @Test
    public void rootTest() {
        goTo("http://localhost:4567");
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
    
    @Test
    public void testSuosituinSivuToimii() {
        goTo("http://localhost:4567/suosituin");
        String otsikko = webDriver.findElement(By.cssSelector("h1")).getText();
        System.out.println("test suosituin otsikko on: ");
        Assert.assertTrue(otsikko.equals("Suosituin uutinen"));
    }

    @Test
    public void testSuosituinTitleLoytyy() {
        goTo("http://localhost:4567/suosituin");
        String title = webDriver.findElement(By.cssSelector(".title")).getText();
        System.out.println("test suosituin title on: " + title);
        Assert.assertTrue(title.lastIndexOf("Suosituin uutinen on") != -1);
    }

    @Test
    public void testSuosituinnUrlLoytyy() {
        goTo("http://localhost:4567/suosituin");
        String URL = webDriver.findElement(By.cssSelector("a")).getAttribute("href");
        Assert.assertTrue(URL.lastIndexOf("http://") != -1);
    }
    
    @Test
    public void testViimeisinSivuToimii() {
        goTo("http://localhost:4567/viimeisin");
        String otsikko = webDriver.findElement(By.cssSelector("h1")).getText();
        System.out.println("test viimeisin otsikko on: " + otsikko);
        Assert.assertTrue(otsikko.equals("Viimeisin uutinen"));
    }

    @Test
    public void testViimeisinTitleLoytyy() {
        goTo("http://localhost:4567/viimeisin");
        String title = webDriver.findElement(By.cssSelector(".title")).getText();
        System.out.println("test viimeisin title on: " + title);
        Assert.assertTrue(title.lastIndexOf("Viimeisin uutinen on") != -1);
    }

    @Test
    public void testViimeisinnUrlLoytyy() {
        goTo("http://localhost:4567/viimeisin");
        String URL = webDriver.findElement(By.cssSelector("a")).getAttribute("href");
        Assert.assertTrue(URL.lastIndexOf("http://") != -1);
    }
}
