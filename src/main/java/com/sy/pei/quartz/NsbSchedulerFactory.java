package com.sy.pei.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class NsbSchedulerFactory {
	private static Scheduler  scheduler =null;
	
	public static Scheduler getScheduler(){
		if(scheduler == null){
			try {
				scheduler = StdSchedulerFactory.getDefaultScheduler();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return scheduler;
	}
}
