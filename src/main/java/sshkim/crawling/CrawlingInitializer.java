package sshkim.crawling;

import sshkim.crawling.master.CrawlingAdministration;
import sshkim.crawling.master.MasterCrawling;

/**
 * Created by sshkim on 2016. 10. 26..
 */
public class CrawlingInitializer {

    private volatile static CrawlingInitializer uniqueInstance = null;

    public static void main(String[] args) {
        CrawlingInitializer crawlingInitializer = new CrawlingInitializer().getInstance();
        crawlingInitializer.start();
    }

    private void start() {
        CrawlingAdministration masterCrawling = new MasterCrawling();


    }

    public static CrawlingInitializer getInstance() {

        synchronized (CrawlingInitializer.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new CrawlingInitializer();
            }
        }
        return uniqueInstance;
    }
}
