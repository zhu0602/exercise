package testdailytimeintervaltrigger;

import org.quartz.DailyTimeIntervalScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TimeOfDay;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class DailyTimeIntervalTrigger {

	public static void main(String[] args) throws SchedulerException { 
		// 获取一个调度工厂
		StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
		//获取一个调度器
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		//我想这个任务每天9点开始执行，到下午的5点结束执行，每隔1小时执行一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1", "group1").
				withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().startingDailyAt(TimeOfDay.hourAndMinuteOfDay(10, 0))//这里是指9点开始
						.endingDailyAt(TimeOfDay.hourAndMinuteOfDay(23, 0)).withIntervalInHours(1).withRepeatCount(60)).build();
		
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
