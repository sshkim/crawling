package sshkim.crawling.network;

/**
 * Created by sshkim on 2016. 10. 11..
 */
public class TestNettyNetwork {

    public static void main(String[] args){

        NettyNetwork nettyNetwork = NettyNetwork.getInstance();
        try {
            nettyNetwork.start();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
