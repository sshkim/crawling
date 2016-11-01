package sshkim.crawling.master;

import sshkim.crawling.master.scheduler.MasterScheduler;
import sshkim.crawling.network.NettyNetwork;

/**
 * Created by sshkim on 2016. 10. 26..
 */
public class MasterInitializer extends AbstractCrawling {

    public volatile static MasterInitializer uniqueInstance;

    public static MasterInitializer getInstance() {

        synchronized (MasterInitializer.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new MasterInitializer();
            }
        }
        return uniqueInstance;
    }

    public void start() throws Exception {

        MasterScheduler.getInstance().start();

        NettyNetwork.getInstance().start();

    }
}
