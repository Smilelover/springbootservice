package com.example.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @author cjn
 */

@Configuration
@MapperScan(basePackages = { "com.peilian.guarder.mapper" }, sqlSessionTemplateRef = "musicSqlSessionTemplate")
public class DataSourceMallMvsConf {

	@Bean(name = "musicDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mall")
	@Primary
	public DataSource musicDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "musicSqlSessionFactory")
	@Primary
	public SqlSessionFactory musicSqlSessionFactory(@Qualifier("musicDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "musicTransactionManager")
	@Primary
	public DataSourceTransactionManager musicTransactionManager(@Qualifier("musicDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "musicSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate musicSqlSessionTemplate(@Qualifier("musicSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
