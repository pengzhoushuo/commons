package com.upeng.commons.test.orm;

import com.upeng.commons.orm.QueryParam;

public class Comment3QueryParam extends QueryParam{

	private String _se_content;
	
	private String _ne_object_id;
	
	private String _dnl_create_date;
	
	private String other;
	
	protected int countPerPage = 10;
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String get_dnl_create_date() {
		return _dnl_create_date;
	}

	public void set_dnl_create_date(String dnlCreateDate) {
		_dnl_create_date = dnlCreateDate;
	}

	public String get_ne_object_id() {
		return _ne_object_id;
	}

	public void set_ne_object_id(String neObjectId) {
		_ne_object_id = neObjectId;
	}

	public String get_se_content() {
		return _se_content;
	}

	public void set_se_content(String seContent) {
		_se_content = seContent;
	}

}
