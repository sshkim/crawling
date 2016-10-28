package sshkim.crawling.master.server;

/**
 * Created by sshkim on 2016. 10. 28..
 */
public enum MasterCrawlingProtocol {

    PER_HOUR_CRAWLING("perHourCrawling");

    private String value;

    MasterCrawlingProtocol(final String value) {
        this.value = value;
    }

    public String getProtocol() {
        return value;
    }

    public static MasterCrawlingProtocol fromValue(String value) {

        if (value == null)
            return null;

        for (MasterCrawlingProtocol protocol : MasterCrawlingProtocol.values()) {
            if (value.equals(protocol.getProtocol()))
                return protocol;
        }
        return null;
    }
}
