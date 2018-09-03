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
// import org.springframework.context.annotation.Primary;
// import
// org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
/// **
// *
// * @ClassName: CreditQueryDBConfig
// * @Description: 创建credit-query的SqlSession
// * @author zyl
// * @date 2017年10月22日
// *
// */
// @Configuration
// @MapperScan(basePackages = {
// "com.finup.dataeco.mapper.creditquery" }, sqlSessionFactoryRef =
// "creditquerySqlSessionFactory")
// @Primary
// public class CreditQueryDBConfig {
// @Bean(name = "creditqueryDataSource")
// @ConfigurationProperties(prefix = "spring.datasource.creditquery") //
// application.properteis中对应属性的前缀
// @Primary // 需要指定主库，不然会报错
// public DataSource dataSourceC() {
// return DataSourceBuilder.create().build();
// }
//
// @Bean(name = "creditquerySqlSessionFactory")
// public SqlSessionFactory
// sqlSessionFactoryC(@Qualifier("creditqueryDataSource") DataSource dataSource)
// throws Exception {
// SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
// factoryBean.setDataSource(dataSource);
// factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
// .getResources("classpath:mybatis-sqlmapper/creditquery/*.xml"));
// return factoryBean.getObject();
//
// }
//
// @Bean(name = "creditqueryTransactionManager")
// @Primary
// public DataSourceTransactionManager initTransactionManager(
// @Qualifier("creditqueryDataSource") DataSource dataSource) {
// return new DataSourceTransactionManager(dataSource);
// }
//
// @Bean(name = "creditquerysqlSessionTemplate")
// @Primary
// public SqlSessionTemplate initSqlSessionTemplate(
// @Qualifier("creditquerySqlSessionFactory") SqlSessionFactory
// sqlSessionFactory) throws Exception {
// return new SqlSessionTemplate(sqlSessionFactory);
// }
// }
