package com.upeng.commons.orm;

import javax.sql.DataSource;

import com.upeng.commons.lang.Assert;

@SuppressWarnings("unchecked")
public class SqlserverDAO extends AbstractDAO { 

	public SqlserverDAO(DataSource dataSource, Class<?> voClass) {
		super(dataSource, voClass);
	}
	
	public String getListSql(QueryParam param){
		Assert.notNull(table.getIdColumn());
		StringBuilder sb = new StringBuilder();
		
		int startIndex = param.getCountPerPage() * (param.get_pageNo() - 1);
		int endIndex = startIndex + param.getCountPerPage();
		sb.append("SELECT * from (SELECT ROW_NUMBER() OVER(ORDER BY ");
		sb.append(table.getIdColumn());
		sb.append(" ) AS row_number,* FROM ");
		sb.append(table.getTableName());
		sb.append(" ) AS t WHERE row_number > ");
		sb.append(startIndex);
		sb.append(" AND row_number < ");
		sb.append(endIndex);
		sb.append(param.getOrderBySql());
		return sb.toString();
	}
}
