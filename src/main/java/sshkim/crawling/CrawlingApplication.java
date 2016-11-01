package sshkim.crawling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sshkim.crawling.master.MasterInitializer;


/**
 * Created by sshkim on 2016. 10. 26..
 */
public class CrawlingApplication {

    private volatile static CrawlingApplication uniqueInstance = null;
    private final Logger logger = LoggerFactory.getLogger(CrawlingApplication.class);

    private void start(String appTomlPath) throws Exception {
        Const.loadConfigurations(appTomlPath);

        MasterInitializer masterInitializer = new MasterInitializer();
        masterInitializer.start();

        while (true) {
            Thread.sleep(1000);
        }

    }

    public static CrawlingApplication getInstance() {

        synchronized (CrawlingApplication.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new CrawlingApplication();
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        try {
            CrawlingApplication crawlingApplication = new CrawlingApplication().getInstance();
            crawlingApplication.start(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}