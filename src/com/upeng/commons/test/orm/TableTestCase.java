package com.upeng.commons.test.orm;

import com.upeng.commons.orm.Table;

import junit.framework.TestCase;

public class TableTestCase extends TestCase {

	public void testGetInsertSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("INSERT INTO COMMENT(CONTENT,TITLE,CREATEDATE) VALUES(?,?,?)",table.getInsertSql());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertEquals("INSERT INTO Comment2(CONTENT,TITLE,CREATEDATE) VALUES(?,?,?)",table2.getInsertSql());
	}
	
	public void testGetDeleteSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("DELETE FROM COMMENT", table.getDeleteSql());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertEquals("DELETE FROM Comment2",table2.getDeleteSql());
	}
	
	public void testGetDeleteByIdSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("DELETE FROM COMMENT WHERE oid=?",table.getDeleteByIdSql());
		Table table2 = Table.fromClass(Comment2.class);
		try{
			table2.getDeleteByIdSql();
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}
	
	public void testGetUpdateSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("UPDATE COMMENT SET CONTENT=?,TITLE=?,CREATEDATE=? WHERE oid=?",table.getUpdateSql());
		Table table2 = Table.fromClass(Comment2.class);
		try{
			table2.getUpdateSql();
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}
	
	public void testGetCountSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("SELECT COUNT (*) FROM COMMENT",table.getCountSql());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertEquals("SELECT COUNT (*) FROM Comment2",table2.getCountSql());
	}
	
	public void testGetListSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("SELECT * FROM COMMENT", table.getListSql());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertEquals("SELECT * FROM Comment2",table2.getListSql());
	}
	
	public void testGetListByIdSql(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("SELECT * FROM COMMENT WHERE oid=?",table.getListByIdSql());
		Table table2 = Table.fromClass(Comment2.class);
		try{
			table2.getListByIdSql();
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}
	
	public void testGetIdColumn(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("oid",table.getIdColumn());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertNull(table2.getIdColumn());
	}
	
	public void testGetIdField(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("id",table.getIdField());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertNull(table2.getIdField());
	}
	
	public void testGetTableName(){
		Table table = Table.fromClass(Comment.class);
		TestCase.assertEquals("COMMENT",table.getTableName());
		Table table2 = Table.fromClass(Comment2.class);
		TestCase.assertEquals("Comment2", table2.getTableName());
	}
}
