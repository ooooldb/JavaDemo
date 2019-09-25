package com.xiayu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.xiayu"})
@MapperScan("com.xiayu.online.core.*.dao")
public class XiaYuApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XiaYuApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(XiaYuApplication.class, args);
    }
}
