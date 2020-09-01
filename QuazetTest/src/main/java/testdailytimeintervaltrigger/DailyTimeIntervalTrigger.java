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
		// ��ȡһ�����ȹ���
		StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
		//��ȡһ��������
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		//�����������ÿ��9�㿪ʼִ�У��������5�����ִ�У�ÿ��1Сʱִ��һ��
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1", "group1").
				withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().startingDailyAt(TimeOfDay.hourAndMinuteOfDay(10, 0))//������ָ9�㿪ʼ
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
