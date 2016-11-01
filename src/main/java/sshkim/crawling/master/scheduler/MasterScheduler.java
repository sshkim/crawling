package sshkim.crawling.master.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import sshkim.crawling.Const;
import sshkim.crawling.master.server.MasterCrawlingProtocol;

/**
 * Created by sshkim on 2016. 10. 28..
 */
public class MasterScheduler {

    private volatile static MasterScheduler uniqueInstance;
    private Scheduler scheduler;

    public static MasterScheduler getInstance() {

        synchronized (MasterScheduler.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new MasterScheduler();
            }
        }

        return uniqueInstance;
    }

    public void start(){
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        try {
            addScheduleJob(MasterCrawlingProtocol.PER_HOUR_CRAWLING, Const.CRAWLING_CRON_TIME);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    private void addScheduleJob(MasterCrawlingProtocol protocol, String cronExpression) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(MasterSchedulerFactory.class)
                .withIdentity(protocol.getProtocol())
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
