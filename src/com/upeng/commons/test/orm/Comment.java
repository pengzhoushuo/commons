package com.upeng.commons.test.orm;

import java.util.Date;

import com.upeng.commons.orm.annotation.ColumnName;
import com.upeng.commons.orm.annotation.Id;
import com.upeng.commons.orm.annotation.TableName;

/*
 * test 
 */
@TableName(value = "COMMENT")
public class Comment {
	
	@Id(value="oid")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ColumnName(value="TITLE")
	private String title;
	
	@ColumnName(value="CONTENT")
	private String content;
	
	@ColumnName(value="CREATEDATE")
	private Date createDate;
}
