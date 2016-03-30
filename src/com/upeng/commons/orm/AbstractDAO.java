package com.upeng.commons.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import com.upeng.commons.beans.ExpressionUtils;
import com.upeng.commons.lang.Assert;
import com.upeng.commons.sql.JdbcTemplate;
import com.upeng.commons.sql.Row;

public abstract class AbstractDAO implements DAO {
	
	protected Class<?> voClass;
	
	protected JdbcTemplate template = null;
	
	protected Table table;

	public AbstractDAO(DataSource dataSource, Class<?> voClass){
		this.template = new JdbcTemplate(dataSource);
		this.voClass = voClass;
		table = Table.fromClass(voClass);
	}

	public void execSql(String sql) {
		template.execute(sql);
	}
	
	public Object findById(Serializable id){
		return template.queryObjectUseAnnotation(voClass, table.getListByIdSql(), new Object[]{id}, null, table.getColumnName2FieldnameWithId());
	}

	public Object find(QueryParam param){
		return template.queryObjectUseAnnotation(voClass, table.getListSql() + param.getWhereCaseSql(), param.getObjects(), null, table.getColumnName2FieldnameWithId());
	}
	
	public Row findRow(QueryParam param) {
		return template.queryForRow(table.getListSql() + param.getWhereCaseSql(), param.getObjects());
	}

	public List<Row> findRowList(QueryParam param) {
		if(param.getCountPerPage() < 1){
			return template.queryForRowList(table.getListSql() + param.getWhereCaseSql() + param.getOrderBySql(), param.getObjects());
		}else{
			return template.queryForRowList(this.getListSql(param), param.getObjects());
		}
	}

	@SuppressWarnings("unchecked")
		public List list(QueryParam param) {
		if(param.getCountPerPage() < 1){
			return template.queryObjectListUseAnnotation(voClass, table.getListSql() + param.getWhereCaseSql() + param.getOrderBySql(), param.getObjects(), null, table.getColumnName2FieldnameWithId());
		}else{
			return template.queryObjectListUseAnnotation(voClass, this.getListSql(param), param.getObjects(), null, table.getColumnName2FieldnameWithId());
		}
	}

	public void save(Object obj){
		template.update(table.getInsertSql(), getObjects(obj));
	}

	public int count(QueryParam param) {
		return template.queryForInt(table.getCountSql() + param.getWhereCaseSql(), param.getObjects());
	}

	public int count() {
		return template.queryForInt(table.getCountSql());
	}
	
	public void removeById(Serializable id) {
		template.update(table.getDeleteByIdSql(), new Object[]{id});
	}
	
	public void removeByIds(Serializable... ids) {
		Assert.notNull(table.getIdColumn());
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(table.getDeleteSql());
		int i=0;
		for(Serializable id : ids){
			if(i == 0){
				sqlSb.append(" WHERE ");
			}else{
				sqlSb.append(" OR ");
			}
			sqlSb.append(table.getIdColumn());
			sqlSb.append("=");
			sqlSb.append(id);
			i++;
		}
		this.execSql(sqlSb.toString());
	}

	public void update(Object obj){
		template.update(table.getUpdateSql(), getObjectsWithId(obj));
	}
	
	private Object[] getObjects(Object obj){
		List<Object> objectList = new ArrayList<Object>();
		Set<Map.Entry<String, String>> set = this.table.getFieldname2Columnname().entrySet();
		for(Map.Entry<String, String> entry : set){
			objectList.add(ExpressionUtils.getFieldValue(obj, entry.getKey()));
		}
		return objectList.toArray();
	}
	
	private Object[] getObjectsWithId(Object obj){
		List<Object> objectList = new ArrayList<Object>();
		Set<Map.Entry<String, String>> set = this.table.getFieldname2Columnname().entrySet();
		for(Map.Entry<String, String> entry : set){
			objectList.add(ExpressionUtils.getFieldValue(obj, entry.getKey()));
		}
		objectList.add(ExpressionUtils.getFieldValue(obj, table.getIdField()));
		return objectList.toArray();
	}

	public Class<?> getVoClass() {
		return voClass;
	}

	public void setVoClass(Class<?> voClass) {
		this.voClass = voClass;
	}

	public abstract String getListSql(QueryParam param);

}
