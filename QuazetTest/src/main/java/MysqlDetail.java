import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class MysqlDetail  implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		Map  map = jobDetail.getJobDataMap();
		System.out.println("任务执行时间:"+getTime()+map.get("user"));
	}
	
	public static  String getTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		String timeString = simpleDateFormat.format(new Date());
		return timeString;
	}
				

	
	
}
