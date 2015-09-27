/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;

/**
 *
 * @author teemu
 */
public class MockHackerPaivanUutiset extends HackerPaivanUutiset{
    
    public HackerPaivanUutiset hn;
    
    public MockHackerPaivanUutiset() {
//        hn = mock(HackerPaivanUutiset.class);
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

    @Override
    public String haeSuosituinUutinen() {
        return "Suosituin uutinen on (NEWS TITLE), url: http://(NEWS URL)";
    }
    
    @Override
    public String haeViimeisinUutinen() {
        return "Viimeisin uutinen on (NEWS TITLE), url: http://(NEWS URL)";
    }
}
