// package com.finup.dataeco.config;
//
// import javax.sql.DataSource;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
/// **
// *
// * @ClassName: AntiFraudDBConfig
// * @Description: 创建anti_fraud的SqlSession
// * @author zyl
// * @date 2017年10月22日
// *
// */
// @Configuration
//// 指明了扫描dao层，并且给dao层注入指定的SqlSessionTemplate
// @MapperScan(basePackages = {
// "com.finup.dataeco.mapper.antifraud" }, sqlSessionFactoryRef =
// "antifraudSqlSessionFactory")
// public class AntiFraudDBConfig {
// @Bean(name = "antifraudDataSource")
// @ConfigurationProperties(prefix = "spring.datasource.antifraud")
// public DataSource dataSource() {
// return DataSourceBuilder.create().build();
// }
//
// @Bean(name = "antifraudSqlSessionFactory")
// public SqlSessionFactory
// antifraudSqlSessionFactory(@Qualifier("antifraudDataSource") DataSource
// dataSource)
// throws Exception {
// SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
// factoryBean.setDataSource(dataSource);
// factoryBean.setMapperLocations(
// new
// PathMatchingResourcePatternResolver().getResources("classpath:mybatis-sqlmapper/antifraud/*.xml"));
// return factoryBean.getObject();
//
// }
//
// @Bean(name = "antifraudTransactionManager")
// public DataSourceTransactionManager initTransactionManager(
// @Qualifier("antifraudDataSource") DataSource dataSource) {
// return new DataSourceTransactionManager(dataSource);
// }
//
// @Bean(name = "antifraudSqlSessionTemplate")
// public SqlSessionTemplate initSqlSessionTemplate(
// @Qualifier("antifraudSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
// throws Exception {
// SqlSessionTemplate sqlSessionTemplate = new
// SqlSessionTemplate(sqlSessionFactory);
// return sqlSessionTemplate;
// }
// }
