package com.upeng.commons.test;

import com.upeng.commons.net.HttpRequestUtils;
import com.upeng.commons.net.RequestException;

public class Test {

	public static void main(String[] args) throws RequestException{
		for(int i=0; i<100; i++){
			
			System.out.println(i);
			Runner rn = new Runner();
			Thread t = new Thread(rn);
			t.start();
		}
	}
	
	static class Runner implements Runnable{

		@Override
		public void run() {
			while(true){
				try{
					HttpRequestUtils.doHead("http://apk.hiapk.com//Download.aspx?aid=1373395");
					
					//HttpRequestUtils.doGet("http://apps.aliyun.com/downloadLog.htm?appId=33782&appVer=1.4&client=PC1");
					//http://www.candou.com/android/90299
					//HttpRequestUtils.doHead("http://app.candou.com/appdownload.php?action=downloads&source=detail&destination=candou&application_id=90299&apptype=android");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
}
