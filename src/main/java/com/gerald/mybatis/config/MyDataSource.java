package com.gerald.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableConfigurationProperties(MyDataSourceProperties.class)
public class MyDataSource {
	private org.apache.tomcat.jdbc.pool.DataSource pool;
	
	@Bean(destroyMethod = "close")
	@Autowired
	public DataSource dataSource(MyDataSourceProperties dataSourceProperties) {
		MyDataSourceProperties config = dataSourceProperties;		
		this.pool = new org.apache.tomcat.jdbc.pool.DataSource();		
		this.pool.setDriverClassName(config.getDriverClassName());
		this.pool.setUrl(config.getUrl());
		if (config.getUsername() != null) {
			this.pool.setUsername(config.getUsername());
		}
		if (config.getPassword() != null) {
			this.pool.setPassword(config.getPassword());
		}
		this.pool.setDefaultAutoCommit(config.isDefaultAutoCommit());
		this.pool.setInitialSize(config.getInitialSize());
		this.pool.setMaxActive(config.getMaxActive());
		this.pool.setMaxIdle(config.getMaxIdle());
		this.pool.setMinIdle(config.getMinIdle());
		this.pool.setTestOnBorrow(config.isTestOnBorrow());
		this.pool.setTestOnReturn(config.isTestOnReturn());
		this.pool.setTestWhileIdle(config.isTestWhileIdle());
		this.pool.setValidationQuery(config.getValidationQuery());
		this.pool.setValidationInterval(config.getValidationInterval());
		this.pool.setTimeBetweenEvictionRunsMillis(config.getTimeBetweenEvictionRunsMillis());
		this.pool.setMinEvictableIdleTimeMillis(config.getMinEvictableIdleTimeMillis());
		this.pool.setNumTestsPerEvictionRun(config.getNumTestsPerEvictionRun());
		this.pool.setRemoveAbandoned(config.isRemoveAbandoned());
		this.pool.setRemoveAbandonedTimeout(config.getRemoveAbandonedTimeout());
		this.pool.setLogAbandoned(config.isLogAbandoned());
		this.pool.setDefaultTransactionIsolation(config.getDefaultTransactionIsolation());
		//this.pool.setJdbcInterceptors(config.getJdbcInterceptors());
		return this.pool;
	}

	public void close() {
		if (this.pool != null) {
			this.pool.close();
		}
	}
	
	@Bean
	@Autowired
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, org.apache.ibatis.session.Configuration config) {
	    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
	    factory.setDataSource(dataSource);	    
	    factory.setConfiguration(config);
	    
	    return factory;
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis",ignoreUnknownFields = false)
	public org.apache.ibatis.session.Configuration mybatisConfig() {
	    return new org.apache.ibatis.session.Configuration();
	}
	
	@Bean
	@Autowired
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
	    return new SqlSessionTemplate(factory);
	}
	
	@Bean
	public MapperScannerConfigurer mapperScanner() {
	    MapperScannerConfigurer scanner = new MapperScannerConfigurer();
	    
	    scanner.setBasePackage("com.gerald.mybatis.dao");
	    
	    return scanner;
	}	
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jtm = new JdbcTemplate();
		jtm.setDataSource(dataSource);
		return  jtm;
	}
}
