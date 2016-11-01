package sshkim.crawling.network;

import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sshkim.crawling.master.scheduler.MasterSchedulerFactory;

/**
 * Created by sshkim on 2016. 10. 31..
 */
public class TestScheduler {

    final Logger log = LoggerFactory.getLogger(TestScheduler.class);

    @Before
    public void configure(){

    }

    @Test
    public void test(){

//        JobDataMap dataMap = new JobDataMap();
//
//        QuartzManualJob job1 = new QuartzManualJob("perHourCrawling", MasterSchedulerFactory.class);
//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();
//            scheduler.addJob(job1.getJobDetail(), true);
//            scheduler.triggerJob(job1.getKey(), dataMap);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("end!!!");
    }
}
