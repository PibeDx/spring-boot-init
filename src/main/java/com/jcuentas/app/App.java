package com.jcuentas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jcuentas on 08/01/2016.
 */

@EnableAutoConfiguration
@ComponentScan("com.jcuentas.app")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
