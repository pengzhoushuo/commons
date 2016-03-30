package com.upeng.commons.db;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.upeng.commons.io.FileUtils;

public class HashMapDB {
	
	private static final String extName = ".o";

	//file path of hard disk
	private String storagePath;
	
	//must unique
	private String id;
	
	/**
	 * HashMapDB file path of hard disk
	 * @param storagePath
	 * @param id must unique
	 */
	public HashMapDB(String storagePath, String id){
		this.storagePath = storagePath;
		this.id = id;
		String path = this.storagePath + "/" + this.id;
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	//value
	private Map<String, Object> hashMap = new HashMap<String, Object>();
	
	public void put(String key, Object value){
		if(!hashMap.containsKey(key)){//item is new
			store(key, value);
		}else{
			store(key, value);
		}
		hashMap.put(key,  value);
	}
	
	public Object get(String key){
		return hashMap.get(key);
	}
	
	public int size(){
		return hashMap.size();
	}
	
	public boolean isEmpty(){
		return hashMap.isEmpty();
	}
	
	public void remove(String key){
		if(hashMap.containsKey(key)){
			hashMap.remove(key);
			destore(key);
		}
	}
	
	public synchronized void loadAll(){
		String path = this.storagePath + "/" + this.id;
		List<File> fileList = FileUtils.getFileList(path);
		if(fileList!=null && !fileList.isEmpty()){
			for(File file : fileList){
				if(extName.equals("." + FileUtils.getExtensionName(file))){
					String fileName = FileUtils.getFileName(file.getAbsolutePath()).replace(extName, "");
					Object object = FileUtils.deSerializeObject(file.getAbsolutePath());
					this.hashMap.put(fileName, object);
				}
			}
		}
	}
	
	public synchronized void reload(){
		hashMap.clear();
		loadAll();
	}
	
	public void store(String key, Object value){
		String filePath = getRealFilePath(key);
		FileUtils.serializeObject(filePath, value);
	}
	
	public void destore(String key){
		String filePath = getRealFilePath(key);
		File file = new File(filePath);
		if(file.exists()){
			FileUtils.deleteFileOrFolder(filePath);
		}
	}
	
	public boolean contains(String key){
		return hashMap.containsKey(key);
	}
	
	public String getRealFilePath(String fileName){
		return this.storagePath + "/" + this.id + "/" + fileName + extName;
	}
	
	public String getStoragePath() {
		return storagePath;
	}

	public String getId() {
		return id;
	}
}
