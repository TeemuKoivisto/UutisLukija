/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author teemu
 */
public class Logic {

    private HackerPaivanUutiset hakija;

    public Logic() {
        this.hakija = new HackerPaivanUutiset();
    }

    public void setHackerNews(HackerPaivanUutiset h) {
        this.hakija = h;
    }

    public String[] haeUutinen(String tyyppi) {
        String[] list = new String[2];
        String uutinen;
        if (tyyppi.equals("suosituin")) {
            uutinen = hakija.haeSuosituinUutinen();
        } else {
            uutinen = hakija.haeViimeisinUutinen();
        }
        list[0] = uutinen.substring(0, uutinen.lastIndexOf(","));
        list[1] = uutinen.substring((uutinen.lastIndexOf("url: ") + 5));
        return list;
    }

    public Map<String, Object> luoModelUutisesta(String tyyppi) {
        Map<String, Object> model = new HashMap<>();
        String[] uutinen = this.haeUutinen(tyyppi);
        model.put("title", uutinen[0]);
        model.put("url", uutinen[1]);
        return model;
    }
}
