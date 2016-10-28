package sshkim.crawling.master;

import sshkim.crawling.master.scheduler.MasterScheduler;
import sshkim.crawling.network.NettyNetwork;

/**
 * Created by sshkim on 2016. 10. 26..
 */
public class MasterCrawling extends AbstractCrawling {

    public volatile static MasterCrawling uniqueInstance;

    public static MasterCrawling getInstance() {

        synchronized (MasterCrawling.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new MasterCrawling();
            }
        }
        return uniqueInstance;
    }

    public void start() throws Exception {

        MasterScheduler.getInstance().start();

        NettyNetwork.getInstance().start();

    }
}
