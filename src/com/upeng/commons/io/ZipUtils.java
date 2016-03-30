package com.upeng.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * <p>Compress or UnCompress</p>
 * @author Lucky
 *
 */
public class ZipUtils {

	 private static final int buffer = 2048;  
	 
	 private static final String EXT = ".zip";   
	 
	 private static final String BASE_DIR = "";   
	  
	 private static final String PATH = "/";   
	  
    /**  
     * compress
     * @param srcFile  
     * @throws Exception  
     */  
    public static void compress(File srcFile) throws Exception {   
        String name = srcFile.getName();   
        String basePath = srcFile.getParent();   
        String destPath = basePath + name + EXT;   
        compress(srcFile, destPath);   
    }   
    
    public static void compress(File srcFile, File destFile) throws Exception {   
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(   
                destFile), new CRC32());   
  
        ZipOutputStream zos = new ZipOutputStream(cos);   
        compress(srcFile, zos, BASE_DIR);   
        zos.flush();   
        zos.close();   
    }   
  
    /**  
     * compress file 
     * @param srcFile  
     * @param destPath  
     * @throws Exception  
     */  
    public static void compress(File srcFile, String destPath) throws Exception {   
        compress(srcFile, new File(destPath));   
    }   
   
    private static void compress(File srcFile, ZipOutputStream zos,   
            String basePath) throws Exception {   
        if (srcFile.isDirectory()) {   
            compressDir(srcFile, zos, basePath);   
        } else {   
            compressFile(srcFile, zos, basePath);   
        }   
    }   
  
    /**  
     * compress 
     * @param srcPath  
     * @throws Exception  
     */  
    public static void compress(String srcPath) throws Exception {   
        File srcFile = new File(srcPath);   
        compress(srcFile);   
    }   
   
    public static void compress(String srcPath, String destPath)   
            throws Exception {   
        File srcFile = new File(srcPath);   
        compress(srcFile, destPath);   
    }   
  
    /**  
     * compress dir 
     * @param dir  
     * @param zos  
     * @param basePath  
     * @throws Exception  
     */  
    private static void compressDir(File dir, ZipOutputStream zos,   
            String basePath) throws Exception {   
        File[] files = dir.listFiles();   
        // 构建空目录   
        if (files.length < 1) {   
            ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);   
  
            zos.putNextEntry(entry);   
            zos.closeEntry();   
        }   
        for (File file : files) {   
            // 递归压缩   
            compress(file, zos, basePath + dir.getName() + PATH);   
  
        }   
    }   
  
    private static void compressFile(File file, ZipOutputStream zos, String dir) throws Exception {   
        ZipEntry entry = new ZipEntry(dir + file.getName());   
        zos.putNextEntry(entry);   
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(   
                file));   
        int count;   
        byte data[] = new byte[buffer];   
        while ((count = bis.read(data, 0, buffer)) != -1) {   
            zos.write(data, 0, count);   
        }   
        bis.close();   
        zos.closeEntry();   
    }   
    
    private static void compressFiles(List<File> files, ZipOutputStream zos, String dir) throws Exception {   
    	for(File file : files){
			ZipEntry entry = new ZipEntry(dir + file.getName());   
			zos.putNextEntry(entry);   
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));   
			int count;   
			byte data[] = new byte[buffer];   
			while ((count = bis.read(data, 0, buffer)) != -1) {   
			    zos.write(data, 0, count);   
			}   
			bis.close();  
			zos.closeEntry();   
    	}
	}   
    
    public static void compress(List<File> srcFiles, File destFile) throws Exception {   
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(   
                destFile), new CRC32());   
  
        ZipOutputStream zos = new ZipOutputStream(cos);   
        compressFiles(srcFiles, zos, BASE_DIR);   
        zos.flush();   
        zos.close();   
    }  
    
    /**
     * uncompress
     * @param path
     * @param savepath
     */
    public static void unZip(String path, String savepath){
    	File file = new File(savepath);
    	if(!file.exists()){
    		file.mkdir();
    	}
        int count = -1;  
        int index = -1;  
        try   
        {  
            BufferedOutputStream bos = null;  
            ZipEntry entry = null;  
            FileInputStream fis = new FileInputStream(path);   
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));  
              
            while((entry = zis.getNextEntry()) != null)   
            {  
                byte data[] = new byte[buffer];   
  
                String temp = entry.getName();  
                  
                index = temp.lastIndexOf("/");  
                if(index > -1)  
                    temp = temp.substring(index+1);  
                temp = savepath + temp;  
                  
                File f = new File(temp);  
                f.createNewFile();  
  
                FileOutputStream fos = new FileOutputStream(f);  
                bos = new BufferedOutputStream(fos, buffer);  
                  
                while((count = zis.read(data, 0, buffer)) != -1)   
                {  
                    bos.write(data, 0, count);  
                }  
  
                bos.flush();  
                bos.close();  
            }  
  
            zis.close();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
