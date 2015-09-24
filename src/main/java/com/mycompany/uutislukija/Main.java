
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import com.mycompany.uutislukija.domain.Uutinen;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
//        port(getHerokuAssignedPort());
//        Spark.staticFileLocation("/public");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uutinen", new Uutinen("homoilu yleistynyt", "localhost:4567/homo"));

            return new ModelAndView(model, "public/templates/index.wm");
        }, new VelocityTemplateEngine());
        
        get("/suosituin", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uutinen", new Uutinen("homoilu yleistynyt", "localhost:4567/homo"));

            return new ModelAndView(model, "public/templates/suosituin.wm");
        }, new VelocityTemplateEngine());
        
        get("/viimeisin", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uutinen", new Uutinen("homoilu yleistynyt", "localhost:4567/homo"));

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
    
//    static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        }
//        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
//    }
    
    public static String komennot(){
        return "Komennot: viimeisin, suosituin";
    }
}
