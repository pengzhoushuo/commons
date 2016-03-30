package com.upeng.commons.script;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.upeng.commons.script.impl.FileProvider;
import com.upeng.commons.script.impl.SqlProvider;
import com.upeng.commons.script.impl.SystemProvider;

public abstract class AbstractScript implements Script {

	private static ScriptEngineManager manager = new ScriptEngineManager();
	
	public abstract String getEngineName();
	
	private static Map<String, Object> classMap = new HashMap<String, Object>();
	
	static{
		init();
	}
	
	public static void init(){
		classMap.put("system", new SystemProvider());
		classMap.put("file", new FileProvider());
		classMap.put("sql", new SqlProvider());
	}
	
	@Override
	public Object eval(String content, Map<String, Object> bom) {
		ScriptEngine engine = manager.getEngineByName(getEngineName());
		//bom
		if(bom!=null && !bom.isEmpty()){
			engine.put("_bom", bom);
			Set<Map.Entry<String, Object>> bomSet = bom.entrySet();
			for(Map.Entry<String, Object> bomItem : bomSet){
				engine.put(bomItem.getKey(), bomItem.getValue());
			}
		}
		//provider class
		Set<Map.Entry<String, Object>> providerClassSet = classMap.entrySet();
		for(Map.Entry<String, Object> providerClassItem : providerClassSet){
			engine.put(providerClassItem.getKey(), providerClassItem.getValue());
		}
		try {
			return engine.eval(content);
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object eval(String content) {
		return eval(content, null);
	}
}
