package com.upeng.commons.test.regex;

import com.upeng.commons.lang.builder.ToStringBuilder;
import com.upeng.commons.regex.Regex;

public class TestBean {
	
	@Regex(pattern="input id=\"(.*?)\"", group=1)
	private String id;
	
	@Regex(pattern="name=\"(.*?)\"", group=1)
	private String name;
	
	@Regex(pattern="type=\"(.*?)\"", group=1)
	private String type;
	
	private String other;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
