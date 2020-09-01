package testsimpletriggle;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggle {
	public static void main(String[] args) throws SchedulerException {
		//����һ���򵥵�simpleTriggle
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		//����Trigger
		SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1","group1")
		//��������Ŀ�ʼʱ��		
		.startAt(new Date(System.currentTimeMillis()+5*1000L))
		.withSchedule(SimpleScheduleBuilder.simpleSchedule().
				withIntervalInSeconds(1).
				withRepeatCount(3)//�ظ��Ĵ���
				.repeatForever()
				).build();
		// ��������ʵ��
		JobDetail jobDetail = JobBuilder.newJob(MysqlDetail.class).
		withIdentity("job1","group1").usingJobData("user", "data")
		.build();
		
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		scheduler.shutdown();
		
	}
}
