package com.upeng.commons.test.regex;

import java.util.List;

import com.upeng.commons.collections.CollectionsUtils;
import com.upeng.commons.regex.BeanFromRegexUtils;

import junit.framework.TestCase;

public class BeanFromRegexTestCase extends TestCase {

	public void testGetBeanFromRegex() throws Exception{
		String str = "<input id=\"randPasswdBtn\" name=\"TestName\" type=\"button\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" />";
		TestBean bean = BeanFromRegexUtils.getBeanFromRegex(TestBean.class, str);
		TestCase.assertEquals("randPasswdBtn", bean.getId());
		TestCase.assertEquals("TestName", bean.getName());
		TestCase.assertEquals("button", bean.getType());
		str = "<input id=\"randPasswdBtn\" name=\"TestName\" type=\"button\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" /><input id=\"randPasswdBtn2\" name=\"TestName2\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" />";
		bean = BeanFromRegexUtils.getBeanFromRegex(TestBean.class, str);
		TestCase.assertEquals("randPasswdBtn", bean.getId());
		TestCase.assertEquals("TestName", bean.getName());
		TestCase.assertEquals("button", bean.getType());
		str = "<input id=\"randPasswdBtn\" fase()fasdf type=\"button\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" /> />";
		bean = BeanFromRegexUtils.getBeanFromRegex(TestBean.class, str);
		TestCase.assertEquals("randPasswdBtn", bean.getId());
		TestCase.assertEquals(null, bean.getName());
		TestCase.assertEquals("button", bean.getType());
	}
	
	public void testGetBeanListFromRegex() throws Exception{
		String str = "<input id=\"randPasswdBtn\" name=\"TestName\" type=\"button\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" />";
		List<TestBean> beanList = BeanFromRegexUtils.getBeanListFromRegex(TestBean.class, str);
		CollectionsUtils.print(beanList);
		TestCase.assertEquals("randPasswdBtn", beanList.get(0).getId());
		TestCase.assertEquals("TestName", beanList.get(0).getName());
		TestCase.assertEquals("button", beanList.get(0).getType());
		str = "<input id=\"randPasswdBtn\" name=\"TestName\" type=\"button\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" /><input id=\"randPasswdBtn2\" name=\"TestName2\" class=\"form_button\" value=\"发送随机密码\" onclick=\"sendRandomPass()\" />";
		beanList = BeanFromRegexUtils.getBeanListFromRegex(TestBean.class, str);
		CollectionsUtils.print(beanList);
		TestCase.assertEquals("randPasswdBtn", beanList.get(0).getId());
		TestCase.assertEquals("TestName", beanList.get(0).getName());
		TestCase.assertEquals("button", beanList.get(0).getType());
		TestCase.assertEquals("randPasswdBtn2", beanList.get(1).getId());
		TestCase.assertEquals("TestName2", beanList.get(1).getName());
		TestCase.assertEquals(null, beanList.get(1).getType());
		str = "";
		beanList = BeanFromRegexUtils.getBeanListFromRegex(TestBean.class, str);
		CollectionsUtils.print(beanList);
		TestCase.assertEquals(0, beanList.size());
	}
}
