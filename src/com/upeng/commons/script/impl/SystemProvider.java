package com.upeng.commons.script.impl;

import java.util.Map;

import com.upeng.commons.script.JsScript;

public class SystemProvider {

	public Object eval(String content){
		return eval(content, null);
	}
	
	public Object eval(String content, Map<String, Object> bom){
		JsScript jsScript = new JsScript();
		return jsScript.eval(content, bom);
	}
}
