package sshkim.crawling;

import io.ous.jtoml.JToml;
import io.ous.jtoml.Toml;

import java.io.File;
import java.io.IOException;

/**
 * Created by sshkim on 2016. 10. 31..
 */
public class Const {

    public static String CRAWLING_CRON_TIME;

    public static int NETWORK_PORT;

    public static String MONGODB_HOST;
    public static int MONGODB_PORT;
    public static int MONGODB_CONNECTION_PER_HOST;
    public static String MONGODB_DBNAME;

    public static void loadConfigurations(String appTomlPath) {
        try {
            Toml toml = JToml.parse(new File(appTomlPath));

            CRAWLING_CRON_TIME = toml.getString("crawling.perHour");

        } catch (IOException e) {

        }
    }
}
