package com.upeng.commons.script.impl;

import java.sql.Connection;
import java.util.List;

import com.upeng.commons.sql.JdbcTemplate;
import com.upeng.commons.sql.Row;

public class SqlProvider {

	public Object queryForObject(Connection conn, final String sql, Object[] args){
		return JdbcTemplate.queryForObject(conn, sql, args);
	}
	
	public Object queryForObject(Connection conn, final String sql){
		return JdbcTemplate.queryForObject(conn, sql);
	}
	
	public Row queryForRow(Connection conn, final String sql){
		return JdbcTemplate.queryForRow(conn, sql);
	}
	
	public Row queryForRow(Connection conn, final String sql, Object[] args){
		return JdbcTemplate.queryForRow(conn, sql, args);
	}
	
	public List<Row> queryForRowList(Connection conn, final String sql){
		return JdbcTemplate.queryForRowList(conn, sql);
	}
	
	public List<Row> queryForRowList(Connection conn, final String sql, Object[] args){
		return JdbcTemplate.queryForRowList(conn, sql, args);
	}
	
	public int queryForInt(Connection conn, final String sql){
		return JdbcTemplate.queryForInt(conn, sql);
	}

	public int queryForInt(Connection conn, final String sql, Object[] args){
		return JdbcTemplate.queryForInt(conn, sql, args);
	}
}
