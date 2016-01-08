package com.jcuentas.app;

import com.jcuentas.app.model.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jcuentas on 08/01/2016.
 */

@EnableAutoConfiguration
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Hello hello() {
        return new Hello("Hello World!");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String greetings(@RequestBody String name){
        return "Hello "+ name;
    }

//    public static void main(String[] args) {
//        SpringApplication.run(HelloController.class, args);
//    }

}
