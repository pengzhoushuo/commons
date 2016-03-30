package com.upeng.commons.test.script;

import java.util.HashMap;
import java.util.Map;

import com.upeng.commons.script.JsScript;

import junit.framework.TestCase;

public class TestJsScript extends TestCase{

	public void testEval(){
		String script = "a=1;b=2;c=a+b;println(c);c;";
		JsScript jsScript = new JsScript();
		TestCase.assertEquals(3.0, jsScript.eval(script));
	}
	
	public void testEval2(){
		String script = "c=a+b;println(c);c;";
		JsScript jsScript = new JsScript();
		Map<String, Object> bom = new HashMap<String, Object>();
		bom.put("a", 2);
		bom.put("b", 2);
		TestCase.assertEquals(4.0, jsScript.eval(script, bom));
	}
	
	public void testEval3(){
		String script = "c=a+b;c=c+parseInt(system.eval('a*2-1+0+2',_bom));println(c);c;";
		JsScript jsScript = new JsScript();
		Map<String, Object> bom = new HashMap<String, Object>();
		bom.put("a", 2);
		bom.put("b", 2);
		TestCase.assertEquals(9.0, jsScript.eval(script, bom));
	}
}
