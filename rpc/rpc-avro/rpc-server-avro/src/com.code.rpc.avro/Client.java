package com.code.rpc.avro;


import com.code.rpc.api.sync.AccountLeftInfoRequest;
import com.code.rpc.api.sync.AccountService;
import com.code.rpc.api.sync.Response;
import com.code.rpc.api.sync.UserStatusRequest;
import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.net.InetSocketAddress;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 16:13
 * @description: 测试端
 */

public class Client {

    private static AccountService proxy;

    public static void main(String[] args) throws Exception {
        NettyTransceiver client = new NettyTransceiver(new InetSocketAddress("127.0.0.1",65111));
        proxy = SpecificRequestor.getClient(AccountService.class, client);
        System.out.println("connected...");
        queryUserStatusInfo();
        queryLeftFlow();
    }


    public static void queryUserStatusInfo() throws AvroRemoteException {
        UserStatusRequest request = new UserStatusRequest();
        Response response = proxy.queryUserStatusInfo(request);
        System.out.printf(response.toString());
    }

    public static void queryLeftFlow() throws AvroRemoteException {
        AccountLeftInfoRequest request = new AccountLeftInfoRequest();
        Response response = proxy.queryLeftFlow(request);
        System.out.printf(response.toString());
    }

}
