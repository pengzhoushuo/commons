package com.upeng.commons.orm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.upeng.commons.lang.Assert;
import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.orm.annotation.ColumnName;
import com.upeng.commons.orm.annotation.Id;
import com.upeng.commons.orm.annotation.TableName;

public class Table {

	private String tableName;
	
	private String idColumn;
	
	private String idField;

	//field name to column name mapping
	private Map<String, String> fieldname2Columnname = new HashMap<String, String>();
	
	//column name to field name mapping with id
	private Map<String, String> columnName2FieldnameWithId = new HashMap<String, String>();

	//cache sqls
	private String insertSql;
	
	private String deleteSql;
	
	private String deleteByIdSql;
	
	private String updateSql;
	
	private String listSql;
	
	private String listByIdSql;
	
	private String coutSql;
	
	//cache tables
	private static Map<Class<?>, Table> cache = new HashMap<Class<?>, Table>();
	
	public static Table fromClass(Class<?> c){
		Assert.notNull(c);
		if(cache.get(c) != null){
			return cache.get(c);
		}
		Table table = new Table();
		//table name
		TableName tableAnnotation = c.getAnnotation(TableName.class);
		if(tableAnnotation == null){//use simple class name as table name 
			table.tableName = c.getSimpleName();
		}else{
			table.tableName = tableAnnotation.value();
		}
		//id and other column
		Object o = null;
		try {
			o = c.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		java.lang.reflect.Field[] filedArray = ClassUtils.getNoStaticNorFinalFieldArray(o);
		for(java.lang.reflect.Field field : filedArray){
			Id idAnnotation = field.getAnnotation(Id.class);
			if(idAnnotation != null){
				if(table.getIdColumn()!=null){
					throw new RuntimeException("Duplicate Id annotation");
				}
				table.setIdColumn(idAnnotation.value());
				table.setIdField(field.getName());
				table.columnName2FieldnameWithId.put(idAnnotation.value(), field.getName());
			}
			ColumnName columnAnnotation = field.getAnnotation(ColumnName.class);
			if(columnAnnotation != null){
				table.getFieldname2Columnname().put(field.getName(), columnAnnotation.value());
				table.columnName2FieldnameWithId.put(columnAnnotation.value(),field.getName());
			}
		}
		cache.put(c, table);
		return table;
	}
	
	public String getInsertSql() {
		if(this.insertSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("INSERT INTO ");
			sqlSb.append(this.getTableName());
			sqlSb.append("(");
			Set<Map.Entry<String, String>> entrySet = this.fieldname2Columnname.entrySet();
			int j = 0;
			for(Map.Entry<String, String> entry : entrySet){
				sqlSb.append(entry.getValue());
				j++;
				if(j!=entrySet.size()){
					sqlSb.append(",");
				}
			}
			sqlSb.append(") VALUES(");
			for(int i = 0; i<entrySet.size(); i++){
				sqlSb.append("?");
				if(i!=entrySet.size() - 1){
					sqlSb.append(",");
				}
			}
			sqlSb.append(")");
			this.insertSql = sqlSb.toString();
		}
		return this.insertSql;
	}
	
	public String getDeleteSql(){
		if(this.deleteSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("DELETE FROM ");
			sqlSb.append(this.getTableName());
			this.deleteSql = sqlSb.toString();
		}
		return this.deleteSql;
	}
	
	public String getDeleteByIdSql() {
		assertIdNotNull();
		if(this.deleteByIdSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("DELETE FROM ");
			sqlSb.append(this.getTableName());
			sqlSb.append(" WHERE ");
			sqlSb.append(this.getIdColumn());
			sqlSb.append("=?");
			this.deleteByIdSql = sqlSb.toString();
		}
		return this.deleteByIdSql;
	}
	
	public String getUpdateSql() {
		assertIdNotNull();
		if(this.updateSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("UPDATE ");
			sqlSb.append(this.getTableName());
			sqlSb.append(" SET ");
			Set<Map.Entry<String, String>> entrySet = this.fieldname2Columnname.entrySet();
			int j=0;
			for(Map.Entry<String, String> entry : entrySet){
				sqlSb.append(entry.getValue());
				sqlSb.append("=?");
				j++;
				if(j!=entrySet.size()){
					sqlSb.append(",");
				}
			}
			sqlSb.append(" WHERE ");
			sqlSb.append(this.getIdColumn());
			sqlSb.append("=?");
			this.updateSql = sqlSb.toString();
		}
		return this.updateSql;
	}

	public String getListSql() {
		if(this.listSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("SELECT * FROM ");
			sqlSb.append(this.getTableName());
			this.listSql = sqlSb.toString();
		}
		return this.listSql;
	}

	public String getListByIdSql() {
		assertIdNotNull();
		if(this.listByIdSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("SELECT * FROM ");
			sqlSb.append(this.getTableName());
			sqlSb.append(" WHERE ");
			sqlSb.append(this.getIdColumn());
			sqlSb.append("=?");
			this.listByIdSql = sqlSb.toString();
		}
		return this.listByIdSql;
	}
	
	public String getCountSql() {
		if(this.coutSql == null){
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("SELECT COUNT(*) FROM ");
			sqlSb.append(this.getTableName());
			this.coutSql = sqlSb.toString();
		}
		return this.coutSql;
	}
	
	public Map<String, String> getFieldname2Columnname() {
		return fieldname2Columnname;
	}

	public void setFieldname2Columnname(Map<String, String> fieldname2Columnname) {
		this.fieldname2Columnname = fieldname2Columnname;
	}
	
	public Map<String, String> getColumnName2FieldnameWithId() {
		return columnName2FieldnameWithId;
	}

	public void setColumnName2FieldnameWithId(
			Map<String, String> columnName2FieldnameWithId) {
		this.columnName2FieldnameWithId = columnName2FieldnameWithId;
	}
	
	private void assertIdNotNull(){
		if(this.idColumn == null){
			throw new RuntimeException("Id Column must be set");
		}
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getIdColumn() {
		return idColumn;
	}

	public void setIdColumn(String idColumn) {
		this.idColumn = idColumn;
	}

	public String getIdField() {
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}
}
