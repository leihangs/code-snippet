package com.code.rpc.avro;

import com.code.rpc.api.sync.AccountService;

/**
 * @author: leihang@live.cn
 * @date: 2016-09-28 11:41
 * @description:后台处理：调用链
 */

public interface ServiceProxy extends AccountService {

    void setNext(ServiceProxy next);
}
