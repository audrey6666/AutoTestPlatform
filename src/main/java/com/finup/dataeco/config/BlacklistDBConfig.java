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
// * @ClassName: BlacklistDBConfig
// * @Description: 创建blacklist的SqlSession
// * @author zyl
// * @date 2017年10月22日
// *
// */
// @Configuration
// @MapperScan(basePackages = {
// "com.finup.dataeco.mapper.blacklist" }, sqlSessionFactoryRef =
// "blacklistSqlSessionFactory")
// public class BlacklistDBConfig {
// @Bean(name = "blacklistDataSource")
// @ConfigurationProperties(prefix = "spring.datasource.blacklist")
// public DataSource dataSource() {
// return DataSourceBuilder.create().build();
// }
//
// @Bean(name = "blacklistSqlSessionFactory")
// public SqlSessionFactory
// blacklistSqlSessionFactory(@Qualifier("blacklistDataSource") DataSource
// dataSource)
// throws Exception {
// SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
// factoryBean.setDataSource(dataSource);
// factoryBean.setMapperLocations(
// new
// PathMatchingResourcePatternResolver().getResources("classpath:mybatis-sqlmapper/blacklist/*.xml"));
// return factoryBean.getObject();
//
// }
//
// @Bean(name = "blacklistTransactionManager")
// public DataSourceTransactionManager initTransactionManager(
// @Qualifier("blacklistDataSource") DataSource dataSource) {
// return new DataSourceTransactionManager(dataSource);
// }
//
// @Bean(name = "blacklistSqlSessionTemplate")
// public SqlSessionTemplate initSqlSessionTemplate(
// @Qualifier("blacklistSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
// throws Exception {
// return new SqlSessionTemplate(sqlSessionFactory);
// }
// }
