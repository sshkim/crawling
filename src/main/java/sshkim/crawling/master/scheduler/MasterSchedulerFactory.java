package sshkim.crawling.master.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sshkim.crawling.master.server.MasterCrawlingProtocol;

/**
 * Created by sshkim on 2016. 10. 28..
 */
public class MasterSchedulerFactory implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        MasterCrawlingProtocol protocol = MasterCrawlingProtocol.fromValue(context.getJobDetail().getKey().getName());

        switch(protocol){
            case PER_HOUR_CRAWLING :
                this.executePerHourCrawling();
                break;
        }
    }

    private void executePerHourCrawling() {

    }
}
