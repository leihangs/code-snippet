package com.code.guides.httpclient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.code.guides.httpclient.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 15:39
 * @description:
 * 测试时需要先启动程序
 */

public class TestRequest2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRequest.class);

    private static final String SERVER_URL = "http://localhost:9999/";

    @Test
    public void getUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(SERVER_URL + "/user/user/02", User.class);
        ObjectMapper m = new ObjectMapper();
        LOGGER.info(m.writeValueAsString(user));
    }
}
