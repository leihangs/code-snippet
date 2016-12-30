package com.code.rpc.avro;

import com.code.rpc.api.sync.AccountLeftInfoRequest;
import com.code.rpc.api.sync.Response;
import com.code.rpc.api.sync.UserStatusInfo;
import com.code.rpc.api.sync.UserStatusRequest;
import org.apache.avro.AvroRemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 12:46
 * @description:
 */

public class DataDealService implements ServiceProxy {

    @Override
    public void setNext(ServiceProxy next) {
        throw new IllegalArgumentException("unable to support action");
    }

    @Override
    public Response queryUserStatusInfo(UserStatusRequest request) throws AvroRemoteException {

        UserStatusInfo userStatusInfo = new UserStatusInfo();
        userStatusInfo.setPhone("18548548545");
        userStatusInfo.setGprs("1");
        userStatusInfo.setSms("1");
        userStatusInfo.setVoice("0");
        Response response = new Response();
        response.setCode("0000");
        response.setDescription("SUCCESS");
        response.setData(userStatusInfo);
        return response;
     }

    @Override
    public Response queryLeftFlow(AccountLeftInfoRequest request) throws AvroRemoteException {

        return null;
    }
}
