package com.upeng.commons.test.orm;

import java.util.Date;

import com.upeng.commons.lang.builder.ToStringBuilder;
import com.upeng.commons.orm.annotation.ColumnName;
import com.upeng.commons.orm.annotation.Id;
import com.upeng.commons.orm.annotation.TableName;

/*
 * DROP TABLE IF EXISTS `comment`;
   CREATE TABLE `COMMENT` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Content` varchar(500) NOT NULL,
  `Object_Id` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `IP` varchar(50) DEFAULT NULL,
  `Create_Date` datetime NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */
@TableName(value="COMMENT")
public class Comment3 {

	@Id(value="Id")
	private int id;
	
	@ColumnName(value="Content")
	private String content;
	
	@ColumnName(value="Object_Id")
	private int objectId;
	
	@ColumnName(value="Type")
	private int type;
	
	@ColumnName(value="IP")
	private String ip;
	
	@ColumnName(value="Create_Date")
	private Date createDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
