
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

// herokuun saaminen : 4h
// siitä turhaa säätöä templatejen kanssa : 2h
// travis ja coveralls : 3.5 h
// coverallsin kanssa turha paskaa noin 2h
// koska travisfilu ei ollut täysin hyvä ja sitten cobertura ei buildaa
// koska jar oli java 8 koska spark vaatii sitä
// vitun lambda funktioillaan
// coberturan excluden kanssa säätäminen jottei turhaan testaisi
// onnetonta templateengineä : 1h
// selenium testejen teko 2h, näköjään tarvitsee mockiton toimiakseen oikein
// selenium testit hajoilee jostain syystä vaikka tein mockluokan HackerUutisista : 1h

public class Main {
    
    public static Logic logiikka;
    
    public static void main(String[] args){
        logiikka = new Logic();
        port(getHerokuAssignedPort());
        get("/", (req, res) -> {
            return new spark.ModelAndView(new HashMap<>(), "public/templates/index.wm");
        }, new VelocityTemplateEngine());
        
        get("/suosituin", (req, res) -> {
            return new ModelAndView(logiikka.luoModelUutisesta("suosituin"), "public/templates/suosituin.wm");
        }, new VelocityTemplateEngine());
        
        get("/viimeisin", (req, res) -> {
            return new ModelAndView(logiikka.luoModelUutisesta("viimeisin"), "public/templates/viimeisin.wm");
        }, new VelocityTemplateEngine());
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
