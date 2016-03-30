package com.upeng.commons.orm;

import javax.sql.DataSource;

@SuppressWarnings("unchecked")
public class OracleDAO extends AbstractDAO { 

	public OracleDAO(DataSource dataSource, Class<?> voClass) {
		super(dataSource, voClass);
	}
	
	public String getListSql(QueryParam param){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM (");
		sb.append("SELECT ");
		sb.append(table.getTableName());
		sb.append(".*");
		sb.append(",ROWNUM rn FROM ");
		sb.append(table.getTableName());
		sb.append(" WHERE ROWNUM <= ");
		sb.append(param.getCountPerPage() * param.get_pageNo());
		sb.append(")");
		sb.append(" WHERE rn > ");
		sb.append(param.getCountPerPage() * (param.get_pageNo()-1));
		return sb.toString();
	}
}
