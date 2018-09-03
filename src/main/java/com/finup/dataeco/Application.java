package com.finup.dataeco;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @ClassName: Application
 * @Description: TODO
 * @author zyl
 * @date 2017年10月22日
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class,
		OAuth2AutoConfiguration.class })
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	/**
	 * Start--->启动嵌入式的Tomcat并初始化Spring环境
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Boot Server started.");
	}
}
