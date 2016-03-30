package com.upeng.commons.orm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.upeng.commons.beans.StringConvertUtils;
import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.lang.StringUtils;

public class QueryParam {
	//count per page
	private int countPerPage = 0;
	//current page number it starts with 1 
	private int _pageNo = 1;
	
	private String _orderBy;
	
	public String getOrderBySql(){
		if(StringUtils.isEmpty(this._orderBy)){
			return StringUtils.EMPTY;
		}else{
			return " ORDER BY " + _orderBy;
		}
	}
	
	public String getWhereCaseSql(){
		StringBuilder sqlSb = new StringBuilder();
		Field[] filedArray = ClassUtils.getNoStaticNorFinalFieldArray(this);
		int i = 0;
		try{
			for(Field field : filedArray){
				String fieldname = field.getName();
				Object o = field.get(this);
				if(o != null){
					String ostr = o.toString();
					if(ostr.length() > 0 && (fieldname.startsWith("_s") || fieldname.startsWith("_n") || fieldname.startsWith("_d"))){
						if(i > 0){
							sqlSb.append(" AND ");
						}else{
							sqlSb.append(" WHERE ");
						}
						if(fieldname.startsWith("_sl")||fieldname.startsWith("_nl")||fieldname.startsWith("_dl")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_snm")||fieldname.startsWith("_nnm")||fieldname.startsWith("_dnm")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_se")||fieldname.startsWith("_ne")||fieldname.startsWith("_de")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_snl")||fieldname.startsWith("_nnl")||fieldname.startsWith("_dnl")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append(">=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_sm")||fieldname.startsWith("_nm")||fieldname.startsWith("_dm")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append(">");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_sne")||fieldname.startsWith("_nbe")||fieldname.startsWith("_dne")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<>");
							sqlSb.append("?");
						}
						i++;
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return sqlSb.toString();
	}
	
	public String getWhereCaseFullSql(){
		StringBuilder sqlSb = new StringBuilder();
		Field[] filedArray = ClassUtils.getNoStaticNorFinalFieldArray(this);
		int i = 0;
		try{
			for(Field field : filedArray){
				String fieldname = field.getName();
				Object o = field.get(this);
				if(o != null){
					String ostr = o.toString();
					if(ostr.length() > 0 && (fieldname.startsWith("_s") || fieldname.startsWith("_n") || fieldname.startsWith("_d"))){
						if(i > 0){
							sqlSb.append(" AND ");
						}else{
							sqlSb.append(" WHERE ");
						}
						if(fieldname.startsWith("_sl")||fieldname.startsWith("_nl")||fieldname.startsWith("_dl")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_snm")||fieldname.startsWith("_nnm")||fieldname.startsWith("_dnm")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_se")||fieldname.startsWith("_ne")||fieldname.startsWith("_de")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_snl")||fieldname.startsWith("_nnl")||fieldname.startsWith("_dnl")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append(">=");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_sm")||fieldname.startsWith("_nm")||fieldname.startsWith("_dm")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append(">");
							sqlSb.append("?");
						}else if(fieldname.startsWith("_sne")||fieldname.startsWith("_nbe")||fieldname.startsWith("_dne")){
							sqlSb.append(getColumnName(fieldname));
							sqlSb.append("<>");
							sqlSb.append("?");
						}
						i++;
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return sqlSb.toString();
	}

	public Object[] getObjects(){
		List<Object> objectList = new ArrayList<Object>();
		try{
			Field[] filedArray = ClassUtils.getNoStaticNorFinalFieldArray(this);
			for(Field field : filedArray){
				Object o = field.get(this);
				if(o != null){
					String ostr = o.toString();
					if(ostr.length() > 0){
						if(field.getName().startsWith("_s")){//string 
							objectList.add(ostr);
						}else if(field.getName().startsWith("_n")){//number
							objectList.add(StringConvertUtils.convertStringToObject(ostr, Long.class));
						}else if(field.getName().startsWith("_d")){//date
							objectList.add(StringConvertUtils.convertStringToObject(ostr, Date.class));
						}
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return objectList.toArray();
	}
	
	private String getColumnName(String fieldName){
		return StringUtils.substringAfter(StringUtils.substringAfter(fieldName, "_"),"_");
	}
	
	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int get_pageNo() {
		return _pageNo;
	}

	public void set_pageNo(int pageNo) {
		_pageNo = pageNo;
	}
	
	public String get_orderBy() {
		return _orderBy;
	}

	public void set_orderBy(String orderBy) {
		this._orderBy = orderBy;
	}
}
