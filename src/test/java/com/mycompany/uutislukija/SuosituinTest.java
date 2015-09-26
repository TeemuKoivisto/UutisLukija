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

public class SuosituinTest extends FluentTest {

    public WebDriver webDriver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @ClassRule
    public static ServerRule server = IndexTest.server;

    @Test
    public void testSivuToimii() {
        goTo("http://localhost:4567/suosituin");
        String otsikko = webDriver.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(otsikko.equals("Suosituin uutinen"));
    }

    @Test
    public void testSuosituinTitleLoytyy() {
        goTo("http://localhost:4567/suosituin");
        String title = webDriver.findElement(By.cssSelector("p")).getText();
        Assert.assertTrue(title.lastIndexOf("Suosituin uutinen on") != -1);
    }

    @Test
    public void testSuosituinnUrlLoytyy() {
        goTo("http://localhost:4567/suosituin");
        String URL = webDriver.findElement(By.cssSelector("a")).getAttribute("href");
        Assert.assertTrue(URL.lastIndexOf("http://") != -1);
    }
}
