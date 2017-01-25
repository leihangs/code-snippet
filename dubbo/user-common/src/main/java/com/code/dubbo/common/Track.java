package com.code.dubbo.common;

import java.io.Serializable;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 14:26
 * @description: 轨迹流水信息
 * requestId(globalId)-->answerId
 * requestId(globalId)-->innerRequestId-->answerId
 */

public class Track implements Serializable {
    //全局流水号,全局流水号，需要保证全局唯一，用于标识一次完整的端到端交易请求
    String globalId;
    //请求流水号，业务域内唯一，用于标识一次接收到的请求。
    String requestId;
    //再次发起的请求流水号，用于标识自身发起请求。
    String innerRequestId;
    //响应流水号，业务域内唯一，用于标识一次响应
    String answerId;

    public Track(String globalId, String requestId, String innerRequestId, String answerId) {
        this.globalId = globalId;
        this.requestId = requestId;
        this.innerRequestId = innerRequestId;
        this.answerId = answerId;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getInnerRequestId() {
        return innerRequestId;
    }

    public void setInnerRequestId(String innerRequestId) {
        this.innerRequestId = innerRequestId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Track{" +
                "globalId='" + globalId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", innerRequestId='" + innerRequestId + '\'' +
                ", answerId='" + answerId + '\'' +
                '}';
    }
}
