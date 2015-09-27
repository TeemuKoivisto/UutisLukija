/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teemu
 */
public class LogiikkaTest {
    
    private Logic logic;
    
    public LogiikkaTest() {
        this.logic = new Logic();
        this.logic.setHackerNews(new MockHackerPaivanUutiset());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHaeSuosituinUutinen() {
        String[] suosituin = this.logic.haeUutinen("suosituin");
        String[] expected = new String[] {"Suosituin uutinen on (NEWS TITLE)", "http://(NEWS URL)"};
        Assert.assertArrayEquals(expected, suosituin);
    }
    
    @Test
    public void testHaeViimeisinUutinen() {
        String[] viimeisin = this.logic.haeUutinen("viimeisin");
        String[] expected = new String[] {"Viimeisin uutinen on (NEWS TITLE)", "http://(NEWS URL)"};
        Assert.assertArrayEquals(expected, viimeisin);
    }
    
    @Test
    public void testLuoModelUutisesta() {
        Map<String, Object> model = this.logic.luoModelUutisesta("suosituin");
        Object title = model.get("title");
        Object url = model.get("url");
        String[] uutinen = new String[2];
        uutinen[0] = title.toString();
        uutinen[1] = url.toString();
//        System.out.println("model title: " + title.toString() + " ja url: " + url.toString());
        String[] expected = new String[] {"Suosituin uutinen on (NEWS TITLE)", "http://(NEWS URL)"};
        Assert.assertArrayEquals(expected, uutinen);
    }
}
