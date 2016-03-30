package com.upeng.commons.lang.time;

/**
 * <p>StopWatch</p>
 * <pre>
 * StopWatch watch = new StopWatch();
 * watch.begin();
 * ...
 * System.out.println(watch.getInterval());
 * ...
 * System.out.println(watch.getInterval());
 * </pre>
 * @author Lucky
 * 1:53:03 PM Sep 8, 2009 
 */
public class StopWatch {

	private long startTime = System.currentTimeMillis();
	
	/**
	 * <p>Start the watch, update the startTime to System.currentTimeMillis()</p>
	 */
	public void begin(){
		this.startTime = System.currentTimeMillis();
	}
	
	/**
	 * <p>The Interval between start time to stop time</p>
	 * @return System.currentTimeMillis() - startTime
	 */
	public long getInterval(){
		long lastStartTime = this.startTime;
		this.startTime = System.currentTimeMillis();
		return System.currentTimeMillis() - lastStartTime;
	}
}
