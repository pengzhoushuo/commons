package com.upeng.commons.script;

import java.util.Map;

public interface Script {

	public Object eval(String content, Map<String, Object> bom);
	
	public Object eval(String content);
	
}
