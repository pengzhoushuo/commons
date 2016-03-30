package com.upeng.commons.script.impl;

import com.upeng.commons.io.FileUtils;

public class FileProvider {

	public String readFile(String path){
		return FileUtils.readFileToString(path).toString();
	}
	
	public void saveToFile(String content, String path){
		FileUtils.saveStringToFile(path, content);
	}
	
}
