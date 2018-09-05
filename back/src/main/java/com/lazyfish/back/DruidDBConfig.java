package com.lazyfish.back;

import com.alibaba.druid.pool.DruidDataSource;
import com.lazyfish.common.utils.LoggerUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;

import javax.sql.DataSource;

@Configuration
public class DruidDBConfig  {
	
	@Value("${spring.druid.datasource.url}")
    private String dbUrl;
    @Value("${spring.druid.datasource.username}")
    private String username;
    @Value("${spring.druid.datasource.password}")
    private String password;

    @Bean(name="druidDataSource")    //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){  
        DruidDataSource datasource = new DruidDataSource();  
          
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName("com.mysql.jdbc.Driver");  
        //configuration
        datasource.setInitialSize(5);  
        datasource.setMinIdle(5);  
        datasource.setMaxActive(20);  
        datasource.setMaxWait(60000);  
        datasource.setTimeBetweenEvictionRunsMillis(60000);  
        datasource.setMinEvictableIdleTimeMillis(300000);  
        datasource.setValidationQuery("SELECT 'x'");  
        datasource.setTestWhileIdle(true);  
        datasource.setTestOnBorrow(false);  
        datasource.setTestOnReturn(false);  
        datasource.setPoolPreparedStatements(false);  
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);  
        try {  
            datasource.setFilters("stat,wall,slf4j");  
        } catch (SQLException e) {  
        	LoggerUtil.error(this.getClass(), e);
        }  
        datasource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");  
        return datasource;  
    } 
    
//    @Bean(name = "transactionManager")
//    @Primary
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
    

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
