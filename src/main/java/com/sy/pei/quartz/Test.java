package com.sy.pei.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;

public class Test {
	public static void main(String[] args) {
		Scheduler scheduler = NsbSchedulerFactory.getScheduler();
		
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("taskinfo", new SimpleJob());
		
		
		JobBuilder jobBulider = 	JobBuilder.newJob(SimpleJob.class)
			.withIdentity("myjob","group1");
		
	}
}
