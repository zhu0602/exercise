package calendertrigger;


import java.util.Date;

import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CalenderTrigger {

	public static void main(String[] args) throws SchedulerException { 
		// 获取一个调度工厂
		StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
		//获取一个调度器
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		//每月执行一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1", "group1").
				withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInMonths(1)).build();
		
		JobDetail jobDetail = JobBuilder.newJob(MysqlDetail.class).withIdentity("job1","group1").usingJobData("user", "zhugg").build();
		
	   scheduler.scheduleJob(jobDetail, trigger);
		
		
		scheduler.start();
		
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduler.shutdown();
	}
}
