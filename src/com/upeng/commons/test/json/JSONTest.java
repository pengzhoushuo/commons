package com.upeng.commons.test.json;

import com.upeng.commons.json.JSON;
import com.upeng.commons.lang.time.StopWatch;

public class JSONTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//test1();
		//test2();
		//test3();
		test4();

	}
	
	public static void test1(){
		String str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":{\"user_id\":16000,\"icon32\":\"http://210.193.49.105/avatar/unknown_32x32.png\",\"icon48\":\"http://210.193.49.105/avatar/unknown_48x48.png\",\"icon64\":\"http://210.193.49.105/avatar/unknown_64x64.png\",\"icon200\":\"http://210.193.49.105/avatar/unknown_96x96.png\"}}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":0.146101}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":[16001,16002,16003,16004,16005,16006,16007,16008,16009]} ";
		//str = "{\"err_code\":0,\"err_msg\":\"bad error\",\"res\":{\"user_id\":1124422,\"name\":\"jialei sun\",\"gender\":\"m\",\"language\":1,\"country\":\"SG\",\"privacy\":0,\"self_intro\":\"这个用户很懒，还没有写任何个人介绍。1227\",\"time_zone\":8,\"pic32\":\"http://210.193.49.105/icon32/200806/22/a281af8d_34305.jpg\",\"pic48\":\"http://210.193.49.105/icon48/200806/22/a281af8d_34305.jpg\",\"pic64\":\"http://210.193.49.105/icon64/200806/22/a281af8d_34305.jpg\",\"pic200\":\"http://210.193.49.105/icon/200806/22/a281af8d_34305.jpg\"},\"res2\":[1,2,3],\"res3\":{\"a\",\"b\",\"c\"},\"res4\":[[[1,11][1,33]][[2,22],[4,44]]]}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":\"USD\"}";
		//str = "{\"name1\":{\"name2\":{\"name3\":\"value3\"}}}";
		JSON json = JSON.fromString(str);
		System.out.println(json.getString("err_code"));
		System.out.println(json.getString("err_msg"));
		System.out.println(json.getString("res.user_id"));
		JSON subJson = json.getJSON("res");
		System.out.println(subJson.getString("user_id"));
		System.out.println(json);
		System.out.println(subJson);
	}
	
	public static void test2(){
		String str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":{\"user_id\":16000,\"icon32\":\"http://210.193.49.105/avatar/unknown_32x32.png\",\"icon48\":\"http://210.193.49.105/avatar/unknown_48x48.png\",\"icon64\":\"http://210.193.49.105/avatar/unknown_64x64.png\",\"icon200\":\"http://210.193.49.105/avatar/unknown_96x96.png\"}}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":0.146101}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":[16001,16002,16003,16004,16005,16006,16007,16008,16009]} ";
		//str = "{\"err_code\":0,\"err_msg\":\"bad error\",\"res\":{\"user_id\":1124422,\"name\":\"jialei sun\",\"gender\":\"m\",\"language\":1,\"country\":\"SG\",\"privacy\":0,\"self_intro\":\"这个用户很懒，还没有写任何个人介绍。1227\",\"time_zone\":8,\"pic32\":\"http://210.193.49.105/icon32/200806/22/a281af8d_34305.jpg\",\"pic48\":\"http://210.193.49.105/icon48/200806/22/a281af8d_34305.jpg\",\"pic64\":\"http://210.193.49.105/icon64/200806/22/a281af8d_34305.jpg\",\"pic200\":\"http://210.193.49.105/icon/200806/22/a281af8d_34305.jpg\"},\"res2\":[1,2,3],\"res3\":{\"a\",\"b\",\"c\"},\"res4\":[[[1,11][1,33]][[2,22],[4,44]]]}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":\"USD\"}";
		
		StopWatch watch = new StopWatch();
		JSON json = JSON.fromString(str);
		JSON subJson = json.getJSON("res");
		for(int i=0; i<10000; i++){			
			json.getString("err_code");
			json.getString("err_msg");
			json.getString("res.user_id");			
			
			subJson.getString("user_id");
			json.toString();
			subJson.toString();
		}
		System.out.println(watch.getInterval());
	}
	
	public static void test3(){
//		String str = "[{\"flid\":1210230701236,\"name\":\"aaa\"}]";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":0.146101}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":[16001,16002,16003,16004,16005,16006,16007,16008,16009]} ";
		//str = "{\"err_code\":0,\"err_msg\":\"bad error\",\"res\":{\"user_id\":1124422,\"name\":\"jialei sun\",\"gender\":\"m\",\"language\":1,\"country\":\"SG\",\"privacy\":0,\"self_intro\":\"这个用户很懒，还没有写任何个人介绍。1227\",\"time_zone\":8,\"pic32\":\"http://210.193.49.105/icon32/200806/22/a281af8d_34305.jpg\",\"pic48\":\"http://210.193.49.105/icon48/200806/22/a281af8d_34305.jpg\",\"pic64\":\"http://210.193.49.105/icon64/200806/22/a281af8d_34305.jpg\",\"pic200\":\"http://210.193.49.105/icon/200806/22/a281af8d_34305.jpg\"},\"res2\":[1,2,3],\"res3\":{\"a\",\"b\",\"c\"},\"res4\":[[[1,11][1,33]][[2,22],[4,44]]]}";
		//str = "{\"err_code\":0,\"err_msg\":\"\",\"res\":\"USD\"}";
//		
//		@SuppressWarnings("unused")
//		StopWatch watch = new StopWatch();
//		@SuppressWarnings("unused")
//		JSON json = JSON.fromString(str);
		//System.out.println(json.); 
	}
	public static void test4(){
		String str = "{\"stat\":\"fail\", \"code\":108, \"message\":\"Invalid frob\"}";
		JSON json = JSON.fromString(str);
		System.out.println(json.getString("stat"));
		System.out.println(json.getString("code"));
		System.out.println(json.getString("message"));
	}
}
