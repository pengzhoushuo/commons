/*
 * @# TableMetaData.java.java 3:58:49 PM Feb 7, 2010 2010
 * Copyright 2010 UnclePeng. All rights reserved.
 */
package com.upeng.commons.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upeng.commons.lang.BooleanUtils;
import com.upeng.commons.text.JavaBean;

/**
 * <p>Database Table Meta</p>
 * @author UnclePeng
 */
public class TableMetaData {

	public String name;
	
	private List<ColumnMetaData> columnMetaDatas;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ColumnMetaData> getColumnMetaDatas() {
		return columnMetaDatas;
	}

	public void setColumnMetaDatas(List<ColumnMetaData> columnMetaDatas) {
		this.columnMetaDatas = columnMetaDatas;
	}

	public int getCount(){
		return columnMetaDatas.size();
	}

	public String getSqlScriptInsert(){
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(this.name + " (");
		int i = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(!cmd.isAutoIncrement() && !cmd.isReadOnly()){
				if(i > 0){
					sb.append(",");
				}
				sb.append(cmd.getName());
				i++;
			}
		}
		sb.append(" ) VALUES (");
		for(int j=0; j<i; j++){
			if(j>0){
				sb.append(",");
			}
			sb.append("?");
		}
		sb.append(")");
		sb.toString();
		return sb.toString();
	}
	
	public String getSqlScriptSelect(){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		int i = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(i > 0){
				sb.append(",");
			}
			sb.append(cmd.getName());
			i++;
		}
		sb.append(" FROM ");
		sb.append(this.getName());
		return sb.toString();
	}
	
	public String getSqlScriptUpdateByFirstField(){
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + this.getName() + " SET ");
		int i = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(!cmd.isAutoIncrement() && !cmd.isReadOnly()){
				if(i > 0){
					sb.append(",");
				}
				sb.append(cmd.getName() + " = ?");
				i++;
			}
		}
		sb.append(" WHERE ");
		int j = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(j==0){
				sb.append(cmd.getName() + " = ?");
				j++;
			}	
		}
		return sb.toString();
	}
	
	public String getSqlScriptUpdate(){
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + this.getName() + " SET ");
		int i = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(!cmd.isAutoIncrement()){
				if(i > 0){
					sb.append(",");
				}
				sb.append(cmd.getName() + " = ?");
				i++;
			}
		}
		sb.append(" WHERE ");
		int j = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(!cmd.isAutoIncrement()){
				if(j > 0){
					sb.append(" AND ");
				}
				sb.append(cmd.getName() + " = ?");
				j++;
			}
		}
		return sb.toString();
	}
	
	public String getSqlScriptDelete(){
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM " + this.getName() + " WHERE ");
		int j = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(j > 0){
				sb.append(" AND ");
			}
			sb.append(cmd.getName() + " = ?");
			j++;
		}
		return sb.toString();
	}
	
	public String getSqlScriptDeleteByFirstField(){
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM " + this.getName() + " WHERE ");
		int j = 0;
		for(ColumnMetaData cmd : getColumnMetaDatas()){
			if(j==0){
				sb.append(cmd.getName() + " = ?");
				j++;
			}		
		}
		return sb.toString();
	}
	
	public JavaBean toJavaBean(){
		JavaBean bean = new JavaBean();
		bean.setBeanClassName(TableNameUtils.toClassName(name));
		List<ColumnMetaData> cmds = this.getColumnMetaDatas();
		for(ColumnMetaData cmd : cmds){
			String fieldName = ColumnNameUtils.toFieldName(cmd.getName());
			bean.addField(SqlType2JavaType.getJavaType(cmd.getType()), fieldName);
		}
		return bean;
	}
	
	public static List<TableMetaData> fromConnection(Connection conn) throws SQLException{
		List<TableMetaData> tableMetaDataList = new ArrayList<TableMetaData>();
		ResultSet rs = null;
		ResultSet subRs = null;
	    PreparedStatement pstmt = null;
	    //fetch all table name
		try{
			rs = conn.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
			while(rs.next()){    
				String tableName = rs.getString("TABLE_NAME");  
				TableMetaData tableMetaData = new TableMetaData();
				tableMetaData.setName(tableName);
				tableMetaDataList.add(tableMetaData);
			}
		}finally{
			JdbcUtils.closeQuietly(rs);
		}
		//fetch all column for each table
		try{
			for(TableMetaData tableMetaData : tableMetaDataList){
				 String sql = "SELECT * FROM " + tableMetaData.getName() + "WHERE 1 = 0";
				 pstmt = conn.prepareStatement(sql);
				 subRs = pstmt.executeQuery();
				 if(subRs != null){
					 ResultSetMetaData rsmd = subRs.getMetaData();
					 if(rsmd != null){
						 int count  = rsmd.getColumnCount();
						 List<ColumnMetaData> columnMetaDatas = new ArrayList<ColumnMetaData>(count);
						 for(int i=1; i<=count; i++){
							 ColumnMetaData columnMetaData = new ColumnMetaData();
							 columnMetaData.setName(rsmd.getColumnName(i));
							 columnMetaData.setLabel(rsmd.getColumnLabel(i));
							 columnMetaData.setType(rsmd.getColumnType(i));
							 columnMetaData.setAutoIncrement(rsmd.isAutoIncrement(i));
							 columnMetaData.setReadOnly(rsmd.isReadOnly(i));
							 columnMetaData.setNullAble(BooleanUtils.toBoolean(rsmd.isNullable(i)));
							 columnMetaDatas.add(columnMetaData);
							 tableMetaData.setColumnMetaDatas(columnMetaDatas);
						 }
					 }
				 }
			}
		}finally{
			JdbcUtils.closeQuietly(subRs);
		}
		return tableMetaDataList;
	}
}
