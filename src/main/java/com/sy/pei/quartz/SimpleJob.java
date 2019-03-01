package com.sy.pei.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job{
	public SimpleJob(){
		
	}
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(context.getTrigger().getCalendarName() +" triggered.time is: "+(new Date()));
	}

}
