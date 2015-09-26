/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.junit.Assert;
import org.junit.ClassRule;
import org.openqa.selenium.By;

public class ViimeisinTest extends FluentTest {
    public WebDriver webDriver = new HtmlUnitDriver();
    
    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }
    
    @ClassRule
    public static ServerRule server = IndexTest.server;
    
    @Test
    public void testSivuToimii() {
        goTo("http://localhost:4567/viimeisin");
        String otsikko = webDriver.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(otsikko.equals("Viimeisin uutinen"));
    }

    @Test
    public void testViimeisinTitleLoytyy() {
        goTo("http://localhost:4567/viimeisin");
        String title = webDriver.findElement(By.cssSelector("p")).getText();
        Assert.assertTrue(title.lastIndexOf("Viimeisin uutinen on") != -1);
    }

    @Test
    public void testViimeisinnUrlLoytyy() {
        goTo("http://localhost:4567/viimeisin");
        String URL = webDriver.findElement(By.cssSelector("a")).getAttribute("href");
        Assert.assertTrue(URL.lastIndexOf("http://") != -1);
    }
}
