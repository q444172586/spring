package org.spring.utils.job;

import org.utils.job.QuartzManager;

public class TestJob {
	
	public static String JOB_NAME = "动态任务调度";  
    public static String TRIGGER_NAME = "动态任务触发器";  
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";
    
    public static void main(String[] args) {
        try {  
            System.out.println("【系统启动】开始(每1秒输出一次)...");    
            QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, MyJob.class, "0/1 * * * * ?");    
            Thread.sleep(5000);
            
            System.out.println("【修改时间】开始(每5秒输出一次)...");    
            QuartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "0/5 * * * * ?");
            Thread.sleep(10000);
            
            System.out.println("【暂停】5秒钟...");   
            QuartzManager.pauseJob(JOB_NAME, JOB_GROUP_NAME);
            Thread.sleep(10000);  
            
            System.out.println("【恢复】...");   
            QuartzManager.resumeJob(JOB_NAME, JOB_GROUP_NAME);

            Thread.sleep(60000);    
            System.out.println("【移除定时】开始...");    
            QuartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME);    
            System.out.println("【移除定时】成功");    
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }

}
