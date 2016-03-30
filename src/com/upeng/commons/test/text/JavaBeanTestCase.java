package com.upeng.commons.test.text;

import java.util.ArrayList;
import java.util.List;

import com.upeng.commons.text.HtmlText;
import com.upeng.commons.text.JavaBean;
import com.upeng.commons.text.JavaBean.Field;
import com.upeng.commons.text.JavaBeanTextBuilder;

import junit.framework.TestCase;

public class JavaBeanTestCase extends TestCase{
	Integer i = 0;
	public void testGenBean() {
		JavaBean bean = new JavaBean();
		bean.setPackageName("com.vipshop");
		bean.setBeanClassName("Tacyz");
		bean.addField("double","id");
		bean.addField("int","subId");
		bean.addField("Integer","age");
		bean.addField("Date","birthday");
		bean.addField("String", "desc");
		JavaBeanTextBuilder.fromJavaBean(bean).saveToFile("D:/com/vipshop/Tacyz.java");
	}
}
