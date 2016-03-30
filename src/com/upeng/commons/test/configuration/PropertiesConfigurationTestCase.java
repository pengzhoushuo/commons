package com.upeng.commons.test.configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import junit.framework.TestCase;

import com.upeng.commons.configuration.Configuration;
import com.upeng.commons.configuration.PropertiesConfiguration;

public class PropertiesConfigurationTestCase extends TestCase{
	
//	public static void testSubSet() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		TestCase.assertEquals(2,pc.subset("oct").size());
//		TestCase.assertEquals(0,pc.subset("octooo").size());
//		TestCase.assertEquals("a.e",pc.subset("oct").keys()[0]);
//		TestCase.assertEquals("e",pc.subset("oct").subset("a").keys()[0]);
//	}
//	
//	public static void testKeys() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		String[] keys = pc.keys();
//		int len = keys.length;
//		TestCase.assertEquals("version", keys[0]);
//		TestCase.assertEquals("strs3", keys[len - 1]);
//		TestCase.assertEquals(0, pc.keys("a").length);
//		TestCase.assertEquals(2, pc.keys("oct").length);
//		TestCase.assertEquals("dbURL",pc.keys("service")[0]);
//	}
//	
//	public static void testGetBoolean() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		TestCase.assertTrue(pc.getBoolean("bo"));
//		TestCase.assertFalse(pc.getBoolean("bo2"));
//		TestCase.assertTrue(pc.getBoolean("bo3", true));
//		TestCase.assertFalse(pc.getBoolean("bo3", false));
//	}
//	
//	public static void testGetNum() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		TestCase.assertEquals(100, pc.getInt("abc"));
//		TestCase.assertEquals(45, pc.getInt("bo", 45));
//		
//		TestCase.assertEquals(100.0F, pc.getFloat("abc"));
//		TestCase.assertEquals(45.0F, pc.getFloat("bo",45));
//		
//		TestCase.assertEquals(100L, pc.getLong("abc"));
//		TestCase.assertEquals(45L, pc.getLong("bo",45));
//		
//		TestCase.assertEquals(new BigDecimal(100), pc.getBigDecimal("abc"));
//		TestCase.assertEquals(new BigDecimal(45), pc.getBigDecimal("bo",new BigDecimal(45)));
//		
//		TestCase.assertEquals(BigInteger.valueOf(100), pc.getBigInteger("abc"));
//		TestCase.assertEquals(BigInteger.valueOf(1), pc.getBigInteger("bo",BigInteger.ONE));
//		
//		byte b = 1;
//		TestCase.assertEquals(100, pc.getByte("abc"));
//		TestCase.assertEquals(b, pc.getByte("bo",b));
//		
//		short s = 2;
//		TestCase.assertEquals(100, pc.getShort(("abc")));
//		TestCase.assertEquals(s, pc.getShort("bo",s));
//	}
//	
//	@SuppressWarnings("deprecation")
//	public static void tetGetDate() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		TestCase.assertEquals(25, pc.getDate("date1").getDate());
//		TestCase.assertEquals(0, pc.getDate("date1").getHours());
//		TestCase.assertEquals(26, pc.getDate("date2").getDate());
//		TestCase.assertEquals(10, pc.getDate("date2").getHours());
//		try{
//			pc.getDate("date3");
//			TestCase.assertTrue(false);
//		}catch(Exception e){
//			TestCase.assertTrue(false);
//		}
//		Date date = new Date();
//		TestCase.assertEquals(date.getTime(),pc.getDate("date3", date).getTime());
//	}
//	
//	public static void testStringArrayAndList() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		String strs[] = pc.getStringArray("strs1");
//		TestCase.assertEquals(8, strs.length);
//		TestCase.assertEquals("abc", strs[0]);
//		TestCase.assertEquals(8, pc.getStringList("strs1").size());
//	}
//	
//	public static void testIntgArray() throws IOException{
//		Configuration pc = new PropertiesConfiguration("system.properties");
//		int strs[] = pc.getIntArray("strs3");
//		TestCase.assertEquals(7, strs.length);
//		TestCase.assertEquals(1, strs[0]);
//		TestCase.assertEquals(7, pc.getIntList("strs3").size());
//	}
//	
	public static void testAdd() throws IOException{
		Configuration pc = new PropertiesConfiguration("system.properties");
		pc.add("addKey1", "addValue1");
		pc.add("addKey2", "addValue2");
		TestCase.assertEquals("addValue1", pc.getString("addKey1"));
		TestCase.assertEquals("addValue2", pc.getString("addKey2"));
	}
	
	public static void testStore() throws IOException{
		Configuration pc = new PropertiesConfiguration("system.properties");
		pc.add("addKey1", "addValue1");
		pc.add("addKey2", "addValue2");
		pc.add("testadfadfaf", "测试的数据");
		pc.store();
	}
}
