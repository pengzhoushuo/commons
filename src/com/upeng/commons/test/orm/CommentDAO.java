package com.upeng.commons.test.orm;


import java.util.Date;

import com.upeng.commons.collections.CollectionsUtils;
import com.upeng.commons.orm.AbstractDAO;
import com.upeng.commons.orm.MysqlDAO;
import com.upeng.commons.orm.OracleDAO;
import com.upeng.commons.orm.SqlserverDAO;

public class CommentDAO extends SqlserverDAO {

	public CommentDAO() {
		super(Global.getDataSource(), Comment3.class);
	}
	
	public static void main(String[] args){
		CommentDAO dao = new CommentDAO();
		Comment3 comment = new Comment3();
		comment.setId(15);
		comment.setContent("test content");
		comment.setCreateDate(new Date());
		comment.setIp("127.0.0.1");
		comment.setObjectId(234);
		comment.setType(1);
		dao.save(comment);
		comment.setContent("update test content");
		dao.update(comment);
		Comment3 comment2 = (Comment3)dao.findById(15);
		System.out.println(comment2);
		dao.removeById(15);
		comment2 = (Comment3)dao.findById(15);
		System.out.println(comment2);
		dao.removeByIds(16,17,18);
		Comment3QueryParam param = new Comment3QueryParam();
		param.setCountPerPage(10);
		param.set_pageNo(4);
		param.set_se_content("abc");
		param.set_ne_object_id("3");
		param.set_dnl_create_date("2001-5-01");
		param.set_orderBy("type desc,create_date desc");
		Comment3 comment3 = (Comment3)dao.find(param);
		System.out.println(comment3);
		System.out.println(dao.count(param));
		System.out.println(dao.findRow(param));
		System.out.println(dao.findRowList(param));
		CollectionsUtils.print(dao.list(param));
		param.set_ne_object_id("");
		param.set_se_content("test content");
		comment3 = (Comment3)dao.find(param);
		System.out.println(comment3);
		CollectionsUtils.print(dao.list(param));
		System.out.println(dao.count());
		System.out.println(dao.count(param));
		System.out.println(dao.findRow(param));
		System.out.println(dao.findRowList(param));
	}

}
