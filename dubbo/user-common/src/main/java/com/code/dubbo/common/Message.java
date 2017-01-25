package com.code.dubbo.common;

import java.io.Serializable;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 14:46
 * @description:
 * 传递的消息体
 */

public class Message implements Serializable {
    public Track track;
    public Object body;

    public Message(Track track, Object body) {
        this.track = track;
        this.body = body;
    }
}
