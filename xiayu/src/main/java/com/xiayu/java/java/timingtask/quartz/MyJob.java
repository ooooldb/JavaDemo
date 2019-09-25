package com.xiayu.java.java.timingtask.quartz;

import org.quartz.*;

/**
 * @author: test_
 * @date: 2019/7/18
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("now is" + System.currentTimeMillis());
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("test job", "group1").build();
    }
}
