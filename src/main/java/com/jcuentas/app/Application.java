package com.jcuentas.app;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jcuentas on 08/01/2016.
 */
/*
@EnableAutoConfiguration
@ComponentScan("com.jcuentas.app")
@EnableSwagger
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
*/



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.jcuentas.app")
@EnableSwagger
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}


