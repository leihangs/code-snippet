package com.code.rpc.avro;

import com.code.rpc.api.sync.AccountLeftInfoRequest;
import com.code.rpc.api.sync.Response;
import com.code.rpc.api.sync.UserStatusRequest;
import org.apache.avro.AvroRemoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 11:48
 * @description:
 */

public class ParameterValidatorProxy implements ServiceProxy {

    private static final Logger logger = LoggerFactory.getLogger(ParameterValidatorProxy.class);

    private ServiceProxy next;

    private static final List<String> APPLITIONS_ID = Arrays.asList("PORTAL");

    @Override
    public void setNext(ServiceProxy next) {
        this.next = next;
    }

    @Override
    public Response queryUserStatusInfo(UserStatusRequest request) throws AvroRemoteException {
        return next.queryUserStatusInfo(request);
    }

    @Override
    public Response queryLeftFlow(AccountLeftInfoRequest request) throws AvroRemoteException {
        return null;
    }

    /**
     * 验证
     *
     * @param appID
     * @param originHost
     * @return
     * @throws Exception
     */
    private String validateHeader(String appID, String originHost, String requestId) throws Exception {
        if (!APPLITIONS_ID.contains(appID)) {
            throw new RuntimeException("ApplicationId is Error");
        }
        if (originHost.toString().length() > 50) {
            String returnHost = originHost.substring(0, 50);
            return returnHost;
        } else {
            return originHost.toString();
        }
    }
}
