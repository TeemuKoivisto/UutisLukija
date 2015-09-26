
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


public class Main {
    public static void main(String[] args){
        HackerPaivanUutiset hakija = new HackerPaivanUutiset();
        port(getHerokuAssignedPort());
        
        get("/", (req, res) -> {
            return new spark.ModelAndView(new HashMap<>(), "public/templates/index.wm");
        }, new VelocityTemplateEngine());
        
        get("/suosituin", (req, res) -> {
            String uutinen = hakija.haeSuosituinUutinen();
            String title = uutinen.substring(0, uutinen.lastIndexOf(","));
            String url = uutinen.substring((uutinen.lastIndexOf("url: ") + 5));
            System.out.println(title + " ja " + url);
            
            Map<String, Object> model = new HashMap<>();
            model.put("title", title);
            model.put("url", url);

            return new ModelAndView(model, "public/templates/suosituin.wm");
        }, new VelocityTemplateEngine());
        
        get("/viimeisin", (req, res) -> {
            String uutinen = hakija.haeViimeisinUutinen();
            String title = uutinen.substring(0, uutinen.lastIndexOf(","));
            String url = uutinen.substring((uutinen.lastIndexOf("url: ") + 5));
            
            Map<String, Object> model = new HashMap<>();
            model.put("title", title);
            model.put("url", url);
            
            return new ModelAndView(model, "public/templates/viimeisin.wm");
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
