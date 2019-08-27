package com.xiayu.JavaDemo.xiayu;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.phk"})
@MapperScan(basePackages = {"com.phk.core.*.dao"})
@EnableCaching
@Slf4j
public class HM_BACKSTAGEApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HM_BACKSTAGEApplication.class);
	}

	// 使用内嵌 tomcat 时的启动入口
	public static void main(String[] args) {
		SpringApplication.run(HM_BACKSTAGEApplication.class, args);
	}
}
