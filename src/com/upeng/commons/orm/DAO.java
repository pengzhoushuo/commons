package com.upeng.commons.orm;

import java.io.Serializable;
import java.util.List;

import com.upeng.commons.sql.Row;

public interface DAO {

	public Object findById(Serializable id) throws Exception;
	
	public Object find(QueryParam param);
	
	public Row findRow(QueryParam param);
	
	public List<Row> findRowList(QueryParam param);
	
	public void removeById(Serializable id);
	
	public void removeByIds(Serializable... ids);
	
	public void update(Object e);
	
	public void save(Object e);
	
	public List<Object> list(QueryParam param);
	
	public int count(QueryParam param);
	
	public int count();
	
	public void execSql(String sql);
}
