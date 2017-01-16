package com.code.guides.httpclient.common;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 12:23
 * @description:
 */

public class HttpResult {

    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回数据
     */
    private String data;

    public HttpResult(Integer status, String data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
