/**
 * 
 */
package com.upeng.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.upeng.commons.collections.CharStack;
import com.upeng.commons.collections.CollectionsUtils;
import com.upeng.commons.lang.Assert;
import com.upeng.commons.lang.StringUtils;

/**
 * <p>File Operation</p>
 * @author Lucky
 *
 */
public class FileUtils {
	
	public static final int BUFFER_SIZE = 4096;

	/**
	 * <p>Get All File List from appointed path, Directory not included</p>
	 * @param path
	 * @return
	 */
	public static List<File> getFileList(String path){
		File file = new File(path);		
		return getFileList(file);
	}
	
	/**
	 * <p>Get All File List from appointed path, Directory not included</p>
	 * @param file
	 * @return
	 */
	public static List<File> getFileList(File file){
		File[] files = file.listFiles();
		if(files == null || files.length < 1){
			return null;
		}
		List<File> fileList = new ArrayList<File>();
		for(File f : files){
			if(!f.isDirectory()){
				fileList.add(f);
			}else{
				fileList = (List<File>)CollectionsUtils.contact(fileList , getFileList(f.getPath()));
			}
		}
		return fileList;
	}
	
	/**
	 * <p>Read from text file, return the file content as a StringBuilder</p>
	 * @param path
	 * @return StringBuilder
	 */
	public static StringBuilder readFileToString(String path){
		BufferedReader reader = null;
		StringBuilder sb = null; 
		try{
			reader = new BufferedReader(new FileReader(path));
			sb = new StringBuilder();
			int c;
			c = reader.read();			
			while(c!=-1){
				sb.append((char)c);
				c = reader.read();				
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			IOUtils.closeQuietly(reader);
		}
		return sb;
	}
	
	/**
	 * <p>Read from text file, return the file content as a StringBuilder</p>
	 * @param path
	 * @param encoding
	 * @return
	 */
	public static StringBuilder readFileToString(String path, String encoding){
		BufferedReader reader = null;
		StringBuilder sb = null; 
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),encoding));
			sb = new StringBuilder();
			int c;
			c = reader.read();			
			while(c!=-1){
				sb.append((char)c);
				c = reader.read();				
			}	
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			IOUtils.closeQuietly(reader);
		}
		return sb;
	}
	
	/**
	 * <p>Save String to text file</p> 
	 * @param path
	 * @param content
	 */
	public static void saveStringToFile(String path, String content){
		makeDir(path);
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(content);	
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			IOUtils.closeQuietly(writer);
		}
	}
	
	/**
	 * <p>Save StringBuilder to text file</p>
	 * @param path
	 * @param content
	 */
	public static void saveStringToFile(String path, StringBuilder content){
		saveStringToFile(path, content.toString());
	}
	
	/**
	 * <p>Save String to text file</p>
	 * @param path
	 * @param content
	 * @param encoding
	 */
	public static void saveStringToFile(String path, String content, String encoding){
		makeDir(path);
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), encoding));
			writer.write(content);	
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			IOUtils.closeQuietly(writer);
		}
	}
	
	/**
	 * <p>Save String to text file</p>
	 * @param path
	 * @param content
	 * @param encoding
	 */
	public static void saveStringToFile(String path, StringBuilder content, String encoding){
		saveStringToFile(path, content.toString(), encoding);
	}
	
	/**
	 * <p>Delete File or folder, if it is a folder delete it's child file first</p>
	 * @param path the path of file or folder to delete
	 * @return
	 */
	public static boolean deleteFileOrFolder(String path){
		return deleteFileOrFolder(new File(path));
	}
	
	/**
	 * <p>Delete File or folder, if it is a folder delete it's child file first</p>
	 * @param file the file or folder to delete
	 * @return
	 */
	public static boolean deleteFileOrFolder(File file){
		if(!file.exists()){
			throw new java.lang.IllegalArgumentException("file not found");
		}
		File[] childs = file.listFiles();
		if(childs == null || childs.length <1){//element
			
		}else{//not element
			for(File child : childs){
				deleteFileOrFolder(child);
			}
		}
		return file.delete();
	}
	
	/**
	 * <p>Get file extension name from file name or file path</p>
	 * @param filePath
	 * @return
	 */
	public static String getExtensionName(String filePath){
		if(StringUtils.isBlank(filePath)){
			return StringUtils.EMPTY;
		}
		int lastDotPos = filePath.lastIndexOf(".");
		int lastPathPos = filePath.lastIndexOf(File.separator);
		if(lastPathPos == -1){
			lastPathPos = filePath.lastIndexOf("/");
		}
		if(lastDotPos != -1){
			if(lastPathPos > lastDotPos){
				return  StringUtils.EMPTY;
			}else{
				return filePath.substring(lastDotPos + 1);
			}
		}else{
			return StringUtils.EMPTY;
		}
	}
	
	/**
	 * <p>Get file extension name from file</p>
	 * @param filePath
	 * @return
	 */
	public static String getExtensionName(File file){
		return getExtensionName(file.getName());
	}
	
	/**
	 * Get file name from file path
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath){
		if(StringUtils.isBlank(filePath)){
			return StringUtils.EMPTY;
		}
		CharStack stack = new CharStack();
		stack.pushString(filePath);
		return stack.popUntil(File.separatorChar,'/');
	}
	
	/**
	 * <p>Force make folder, if the path is a folder path, make it; if the path is a file path, make its parent folder</p>
	 * @param path
	 * @return
	 */
	public static boolean makeDir(String path){
		File file = new File(path);
		if(!file.isDirectory()){
			file = file.getParentFile();
		}
		if(!file.exists()){
			return file.mkdirs();
		}
		return false;
	}
	
	/**
	 * <p>Copy a file or folder(include children folder or file) to appointing path</p>
	 * @param sourceFile
	 * @param toPath
	 */
	public static void copy(File sourceFile, String toPath){
		copy(sourceFile.getPath(), toPath);
	}
	
	/**
	 * <p>Copy a file or folder(include children folder or file) to appointing path</p>
	 * @param sourceFile
	 * @param toPath
	 */
	public static void copy(String fromPath, String toPath){
		makeDir(toPath);
		try{
			InputStream is = new BufferedInputStream(new FileInputStream(fromPath));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(toPath));
			copy(is, os);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * <p>Move a file or folder(include children folder or file) to appointing path</p>
	 * @param fromPath
	 * @param toPath
	 */
	public static void move(String fromPath, String toPath){
		copy(fromPath, toPath);
		FileUtils.deleteFileOrFolder(fromPath);
	}
	
	/**
	 * <p>Move a file or folder(include children folder or file) to appointing path</p>
	 * @param sourceFile
	 * @param toPath
	 */
	public static void move(File sourceFile, String toPath){
		move(sourceFile.getPath(),toPath);
	}

	/**
	 * Copy the contents of the given input File to the given output File.
	 * @param in the file to copy from
	 * @param out the file to copy to
	 * @return the number of bytes copied
	 * @throws IOException in case of I/O errors
	 */
	public static int copy(File in, File out) throws IOException {
		return copy(new BufferedInputStream(new FileInputStream(in)),
		    new BufferedOutputStream(new FileOutputStream(out)));
	}

	/**
	 * Copy the contents of the given byte array to the given output File.
	 * @param in the byte array to copy from
	 * @param out the file to copy to
	 * @throws IOException in case of I/O errors
	 */
	public static void copy(byte[] in, File out) throws IOException {
		ByteArrayInputStream inStream = new ByteArrayInputStream(in);
		OutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));
		copy(inStream, outStream);
	}

	/**
	 * Copy the contents of the given input File into a new byte array.
	 * @param in the file to copy from
	 * @return the new byte array that has been copied to
	 * @throws IOException in case of I/O errors
	 */
	public static byte[] copyToByteArray(File in) throws IOException {
		return copyToByteArray(new BufferedInputStream(new FileInputStream(in)));
	}

	/**
	 * Copy the contents of the given InputStream to the given OutputStream.
	 * Closes both streams when done.
	 * @param in the stream to copy from
	 * @param out the stream to copy to
	 * @return the number of bytes copied
	 * @throws IOException in case of I/O errors
	 */
	public static int copy(InputStream in, OutputStream out) throws IOException {
		try {
			int byteCount = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				byteCount += bytesRead;
			}
			out.flush();
			return byteCount;
		}
		finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * Copy the contents of the given byte array to the given OutputStream.
	 * Closes the stream when done.
	 * @param in the byte array to copy from
	 * @param out the OutputStream to copy to
	 * @throws IOException in case of I/O errors
	 */
	public static void copy(byte[] in, OutputStream out) throws IOException {
		try {
			out.write(in);
		}
		finally {
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * Copy the contents of the given InputStream into a new byte array.
	 * Closes the stream when done.
	 * @param in the stream to copy from
	 * @return the new byte array that has been copied to
	 * @throws IOException in case of I/O errors
	 */
	public static byte[] copyToByteArray(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
		copy(in, out);
		return out.toByteArray();
	}


	/**
	 * Copy the contents of the given Reader to the given Writer.
	 * Closes both when done.
	 * @param in the Reader to copy from
	 * @param out the Writer to copy to
	 * @return the number of characters copied
	 * @throws IOException in case of I/O errors
	 */
	public static int copy(Reader in, Writer out) throws IOException {
		try {
			int byteCount = 0;
			char[] buffer = new char[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				byteCount += bytesRead;
			}
			out.flush();
			return byteCount;
		}
		finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * Copy the contents of the given String to the given output Writer.
	 * Closes the write when done.
	 * @param in the String to copy from
	 * @param out the Writer to copy to
	 * @throws IOException in case of I/O errors
	 */
	public static void copy(String in, Writer out) throws IOException {
		try {
			out.write(in);
		}
		finally {
			IOUtils.closeQuietly(out);
		}
	}

	/**
	 * Copy the contents of the given Reader into a String.
	 * Closes the reader when done.
	 * @param in the reader to copy from
	 * @return the String that has been copied to
	 * @throws IOException in case of I/O errors
	 */
	public static String copyToString(Reader in) throws IOException {
		StringWriter out = new StringWriter();
		copy(in, out);
		return out.toString();
	}
	
	public static List<File> getClassFiles(String parent, String packageDesc){
		Assert.hasText(packageDesc);
		packageDesc = packageDesc.replaceAll(".", File.separator);
		if(packageDesc.endsWith("*")){
			packageDesc = packageDesc.replace("*", "");
		}
		return FileUtils.getFileList(parent + packageDesc);
	}
	
	public static <T extends Object> String getClassFolder(Class<T> c){
		String className = c.getName();
		String classNamePath = className.replace(".", "/") + ".class";
		URL url = c.getClassLoader().getResource(classNamePath);
		String path = url.getFile();
		path = path.replace("%20", " ").replace(".class", "");
		int index = path.lastIndexOf("/");
		if(index > -1){
			path = path.substring(0, index);
		}
		return path;
	}
	
	public static void serializeObject(String path, Object obj){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);                      
            oos.writeObject(obj);
		   }catch(Exception e){
			   throw new RuntimeException(e);
		   }finally{
			   IOUtils.closeQuietly(oos);
			   IOUtils.closeQuietly(fos);
		   }
	}
	
	public static Object deSerializeObject(String path){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
	        fis = new FileInputStream(path);
	        ois = new ObjectInputStream(fis);
	        return ois.readObject();
		}catch(Exception e){
		    throw new RuntimeException(e);
		}finally{
			IOUtils.closeQuietly(ois);
			IOUtils.closeQuietly(fis);
		}
	}
}
