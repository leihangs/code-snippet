package com.code.rpc.avro;

import com.code.rpc.api.sync.AccountService;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 16:13
 * @description:
 */

public class AccountServer {

    private static final Logger logger = LoggerFactory.getLogger(AccountServer.class);

    private NettyServer nettyServer;
    //default port
    private int port = 65111;
    //
    private ServiceProxy serviceProxy;

    public void start() {
        nettyServer = new NettyServer(new SpecificResponder(AccountService.class, serviceProxy), new InetSocketAddress(port));
        logger.info("server start...");
    }

    public void stop() {
        nettyServer.close();
        try {
            nettyServer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setServiceProxy(ServiceProxy serviceProxy) {
        this.serviceProxy = serviceProxy;
    }
}
