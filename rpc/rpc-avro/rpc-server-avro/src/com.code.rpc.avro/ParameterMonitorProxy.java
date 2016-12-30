package com.code.rpc.avro;

import com.code.rpc.api.sync.AccountLeftInfoRequest;
import com.code.rpc.api.sync.Response;
import com.code.rpc.api.sync.UserStatusRequest;
import org.apache.avro.AvroRemoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 11:45
 * @description:输入输出参数监控
 */

public class ParameterMonitorProxy implements ServiceProxy {

    private static final Logger logger = LoggerFactory.getLogger(ParameterMonitorProxy.class);

    private ServiceProxy next;

    @Override
    public void setNext(ServiceProxy next) {
        this.next = next;
    }

    @Override
    public Response queryUserStatusInfo(UserStatusRequest request) throws AvroRemoteException {
        logger.info("queryUserStatusInfo param is : " + request.toString());
        Response response = next.queryUserStatusInfo(request);
        logger.info("queryUserStatusInfo response message is :" + response.toString());
        return response;
    }

    @Override
    public Response queryLeftFlow(AccountLeftInfoRequest request) throws AvroRemoteException {
        logger.info("queryLeftFlow param is : " + request.toString());
        Response response = next.queryLeftFlow(request);
        logger.info("queryLeftFlow response message is :" + response.toString());
        return response;
    }
}
