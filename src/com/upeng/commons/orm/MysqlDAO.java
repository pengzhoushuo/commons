package com.upeng.commons.orm;

import javax.sql.DataSource;

@SuppressWarnings("unchecked")
public class MysqlDAO extends AbstractDAO {

	public MysqlDAO(DataSource dataSource, Class<?> voClass) {
		super(dataSource, voClass);
	}
	
	//limit from index,length
	private String getLimitSql(QueryParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" LIMIT ");
		sqlSb.append(getFromIndex(param));
		sqlSb.append(",");
		sqlSb.append(param.getCountPerPage());
		return sqlSb.toString();
	}
	
	private int getFromIndex(QueryParam param){
		int fromIndex = (param.get_pageNo() - 1) * param.getCountPerPage();
		return fromIndex < 0 ? 0 : fromIndex;
	}
	
	public String getListSql(QueryParam param){
		return table.getListSql() + param.getWhereCaseSql()+ param.getOrderBySql() + getLimitSql(param);
	}
}
