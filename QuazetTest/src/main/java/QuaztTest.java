import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.JobBuilder.newJob;

public class QuaztTest {
	public static void main(String[] args) throws SchedulerException {
		 Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
		 // jobDetail 是执行的任务,trigger是执行任务的时间//
		 Trigger trigger=newTrigger().withIdentity("tr1", "group1")//设置触发器的名字和级别
		.startNow()//启动trigger
		.withSchedule(simpleSchedule()//设置触发器使用什么方式
				.withIntervalInSeconds(1)//1秒执行一次任务
		.repeatForever()//不间断的执行
		).build();
		 
		 //执行的任务
		 JobDetail jobDetail = newJob(MysqlDetail.class).withIdentity("jobDetail1","group1").
				 						usingJobData("user", "boss")//共享数据
				 						.build();
		 
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduler.shutdown();
		
		 
	}
}
