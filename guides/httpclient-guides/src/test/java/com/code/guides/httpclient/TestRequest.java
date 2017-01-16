package com.code.guides.httpclient;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.code.guides.httpclient.common.HttpClientService;
import com.code.guides.httpclient.common.HttpResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 14:20
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRequest.class);

    private static final String SERVER_URL = "http://localhost:9999/";

    @Autowired
    private HttpClientService clientService;

    @Autowired
    WebApplicationContext webApplicationConnect;

    MockMvc mvc;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void getUser2() throws Exception {
        String uri = "/user/user/02";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(status);
        System.out.println(content);
    }

    //方式:需要先启动程序
    // get
    @Test
    public void getUser() throws Exception {
        String responseText = clientService.doGet(SERVER_URL + "/user/user/02");
        ObjectMapper m = new ObjectMapper();
        LOGGER.info(m.writeValueAsString(responseText));
    }

    // get
    @Test
    public void getAll() throws Exception {
        String responseText = clientService.doGet(SERVER_URL + "/user/all");
        ObjectMapper m = new ObjectMapper();
        LOGGER.info(m.writeValueAsString(responseText));
    }

    //get
    @Test
    public void getUserByParam() throws Exception {
        Map<String, String> conditionMap = new HashMap();
        conditionMap.put("userId", "xxx0001");
        String responseText = clientService.doGet(SERVER_URL + "/user/user2", conditionMap);
        ObjectMapper m = new ObjectMapper();
        LOGGER.info(m.writeValueAsString(responseText));
    }

    //post
    @Test
    public void updateUserByParam() throws Exception {
        Map<String, String> conditionMap = new HashMap();
        conditionMap.put("userId", "xxx0001");
        conditionMap.put("userName", "name0003");
        HttpResult responseText = clientService.doPost(SERVER_URL + "/user/update", conditionMap);
        ObjectMapper m = new ObjectMapper();
        LOGGER.info(m.writeValueAsString(responseText));
    }

    //post json
    @Test
    public void updateUserByJson() throws Exception {
        ObjectMapper m = new ObjectMapper();
        String json = "userId=xxx0001&userName=name0003";
        HttpResult responseText = clientService.doPostJson(SERVER_URL + "/user/update", json);
        LOGGER.info(m.writeValueAsString(responseText));
    }

    //download
    @Test
    public void download() throws Exception {
        String url = SERVER_URL + "user/download";
        //指定修改后文件名
        String fileName = "readme.pdf";
        //指定文件路径
        String filePath = "D:\\Helloworld2.PDF";
        clientService.download(url, fileName, filePath);
        LOGGER.info("download success!...");
    }



}
