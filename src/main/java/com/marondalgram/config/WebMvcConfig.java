package com.marondalgram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**")   // http://localhost/images/marobiana_16456453342/sun.png
		.addResourceLocations("file:///D:\\신보람\\web_211015\\6_spring-project\\sns\\workspace\\images/"); // 실제 파일 저장 위치
	}
}
