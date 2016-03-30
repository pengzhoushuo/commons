package com.upeng.commons.test.orm;

import com.upeng.commons.orm.QueryParam;

public class CommentQueryParam extends QueryParam {

	private String _se_title;
	
	private String _dnl_createDate;
	
	private String _ne_type;
	
	public String get_se_title() {
		return _se_title;
	}
	public void set_se_title(String seTitle) {
		_se_title = seTitle;
	}
	public String get_dnl_createDate() {
		return _dnl_createDate;
	}
	public void set_dnl_createDate(String dnlCreateDate) {
		_dnl_createDate = dnlCreateDate;
	}
	public String get_ne_type() {
		return _ne_type;
	}
	public void set_ne_type(String neType) {
		_ne_type = neType;
	}
}
