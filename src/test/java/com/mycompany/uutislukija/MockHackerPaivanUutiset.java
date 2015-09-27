/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;

/**
 *
 * @author teemu
 */
public class MockHackerPaivanUutiset extends HackerPaivanUutiset{

    @Override
    public String haeSuosituinUutinen() {
        return "Suosituin uutinen on (NEWS TITLE), url: http://(NEWS URL)";
    }
    
    @Override
    public String haeViimeisinUutinen() {
        return "Viimeisin uutinen on (NEWS TITLE), url: http://(NEWS URL)";
    }
}
