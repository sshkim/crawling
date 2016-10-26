package sshkim.crawling.network;

/**
 * Created by sshkim on 2016. 10. 11..
 */
public class AppInitializer {

    public static void main(String[] args){

        Application application = Application.getInstance();
        try {
            application.start();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
