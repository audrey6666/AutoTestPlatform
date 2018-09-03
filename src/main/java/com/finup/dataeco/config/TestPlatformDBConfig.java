package com.finup.dataeco.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 
 * @ClassName: testPlatformDBConfig
 * @Description: 创建anti_fraud的SqlSession
 * @author zyl
 * @date 2017年10月22日
 *
 */
@Configuration
// 指明了扫描dao层，并且给dao层注入指定的SqlSessionTemplate
@MapperScan(basePackages = {
		"com.finup.dataeco.mapper.testPlatform" }, sqlSessionFactoryRef = "testPlatformSqlSessionFactory")
public class TestPlatformDBConfig {
	@Bean(name = "testPlatformDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.testPlatform")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "testPlatformSqlSessionFactory")
	public SqlSessionFactory testPlatformSqlSessionFactory(@Qualifier("testPlatformDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:mybatis-sqlmapper/testPlatform/*.xml"));
		return factoryBean.getObject();

	}

	@Bean(name = "testPlatformTransactionManager")
	public DataSourceTransactionManager initTransactionManager(
			@Qualifier("testPlatformDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "testPlatformSqlSessionTemplate")
	public SqlSessionTemplate initSqlSessionTemplate(
			@Qualifier("testPlatformSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}
}
