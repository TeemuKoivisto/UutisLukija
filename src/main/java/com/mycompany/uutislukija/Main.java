
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import com.mycompany.uutislukija.domain.Uutinen;

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


public class Main {
    public static void main(String[] args){
        HackerPaivanUutiset hakija = new HackerPaivanUutiset();
        port(getHerokuAssignedPort());
        
        get("/", (req, res) -> {
            return new spark.ModelAndView(new HashMap<>(), "public/templates/index.wm");
        }, new VelocityTemplateEngine());
        
        get("/suosituin", (req, res) -> {
//            System.out.println();
            
            Map<String, Object> model = new HashMap<>();
            model.put("uutinen", new Uutinen("homoilu yleistynyt", hakija.haeSuosituinUutinen()));

            return new ModelAndView(model, "public/templates/suosituin.wm");
        }, new VelocityTemplateEngine());
        
        get("/viimeisin", (req, res) -> {
//            System.out.println();
            
            Map<String, Object> model = new HashMap<>();
            model.put("uutinen", new Uutinen("homoilu yleistynyt", hakija.haeViimeisinUutinen()));

            return new ModelAndView(model, "public/templates/viimeisin.wm");
        }, new VelocityTemplateEngine());
        
//        HackerPaivanUutiset hakija = new HackerPaivanUutiset();
//        if(args.length == 0 || args[0].isEmpty()){
//            System.out.println("Et antanut komentoa. Käytettävissä olevat komennot: " + komennot());
//        } else if(args[0].equals("viimeisin")){
//            System.out.println(hakija.haeViimeisinUutinen());
//        } else if(args[0].equals("suosituin")){
//            System.out.println(hakija.haeSuosituinUutinen());
//        }
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    
    public static String komennot(){
        return "Komennot: viimeisin, suosituin";
    }
}
