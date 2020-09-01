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
		 // jobDetail ��ִ�е�����,trigger��ִ�������ʱ��//
		 Trigger trigger=newTrigger().withIdentity("tr1", "group1")//���ô����������ֺͼ���
		.startNow()//����trigger
		.withSchedule(simpleSchedule()//���ô�����ʹ��ʲô��ʽ
				.withIntervalInSeconds(1)//1��ִ��һ������
		.repeatForever()//����ϵ�ִ��
		).build();
		 
		 //ִ�е�����
		 JobDetail jobDetail = newJob(MysqlDetail.class).withIdentity("jobDetail1","group1").
				 						usingJobData("user", "boss")//��������
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
