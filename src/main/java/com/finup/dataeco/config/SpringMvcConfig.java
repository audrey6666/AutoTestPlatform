package com.finup.dataeco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.finup.dataeco.interceptor.LoginInterceptor;

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	/**
	 * <p>
	 * add interceptor
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/v1/mengma/**", "/api/v1/bairong/**");
	}

}
