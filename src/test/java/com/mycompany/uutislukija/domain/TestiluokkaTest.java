/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestiluokkaTest {
    
    public TestiluokkaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void arvoLaivaPysyyAlueellaTest() {
        Testiluokka t = new Testiluokka();
        assertEquals(1, t.testiMetodi());
    }
}