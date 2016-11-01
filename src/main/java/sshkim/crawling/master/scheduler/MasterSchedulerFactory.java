package sshkim.crawling.master.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sshkim.crawling.master.server.MasterCrawlingProtocol;

/**
 * Created by sshkim on 2016. 10. 28..
 */
public class MasterSchedulerFactory implements Job {

    private final Logger logger = LoggerFactory.getLogger(MasterSchedulerFactory.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        MasterCrawlingProtocol protocol = MasterCrawlingProtocol.fromValue(context.getJobDetail().getKey().getName());

        switch(protocol){
            case PER_HOUR_CRAWLING :
                this.executePerHourCrawling();
                break;
        }
    }

    private void executePerHourCrawling() {
        System.out.println(System.currentTimeMillis());
    }
}
