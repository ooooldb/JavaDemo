package com.xiayu.JavaDemo.xiayu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.xiayu"})
public class XiaYuApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XiaYuApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(XiaYuApplication.class, args);
    }
}
