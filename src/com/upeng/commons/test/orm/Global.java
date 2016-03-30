package com.upeng.commons.test.orm;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.upeng.commons.configuration.Configuration;
import com.upeng.commons.configuration.PropertiesConfiguration;
import com.upeng.commons.sql.JdbcTemplate;

public class Global {

	private static String version;
	
	private static BasicDataSource ds;
	
	static {
		try{
			Configuration settings = new PropertiesConfiguration("system.properties");
			version = settings.getString("version");
			Configuration serverConf = settings.subset("service");											
			ds = new BasicDataSource();
			ds.setDriverClassName(serverConf.getString("dbDriver"));
			ds.setUrl(serverConf.getString("dbURL"));
			ds.setUsername(serverConf.getString("dbUserName"));
			ds.setPassword(serverConf.getString("dbPassword"));
			//以下为解决mysql 8小时问题
			//休眠时间超过1小时的对象回收
			ds.setMinEvictableIdleTimeMillis(3600000);//1 hour
			//每1小时运行一次回收线程
			ds.setTimeBetweenEvictionRunsMillis(3600000);//1 hour
		}catch(Exception e){
			System.out.println("load system setting error: "+e);
			System.exit(1);
		} 	
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public final static String getVersion(){
		return version;
	}

	public static JdbcTemplate getTemplate(){
		return new JdbcTemplate(getDataSource());
	}
	
	public static void main(String[] args){
		getDataSource();
	}
}
