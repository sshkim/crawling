package sshkim.crawling.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import sshkim.crawling.network.service.ApplicationServerHandler;

/**
 * Created by sshkim on 2016. 10. 11..
 */
public class NettyNetwork {

    private volatile static NettyNetwork uniqueInstance = null;

    private int port = 8080;

    public static NettyNetwork getInstance() {
        synchronized (NettyNetwork.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new NettyNetwork();
            }
        }
        return uniqueInstance;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new ApplicationServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
