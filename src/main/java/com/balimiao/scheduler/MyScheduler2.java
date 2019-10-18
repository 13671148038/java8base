package com.balimiao.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/9/4
 **/
public class MyScheduler2 {
    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
        SimpleTrigger myTrigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2)).build();
        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        sched.start();
        sched.scheduleJob(jobDetail, myTrigger);
//        sched.shutdown();
    }
}
