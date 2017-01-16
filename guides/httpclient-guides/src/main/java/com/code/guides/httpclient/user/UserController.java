package com.code.guides.httpclient.user;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.code.guides.httpclient.common.HttpClientService;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-13 11:42
 * @description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable("userId") String userId) {
        LOGGER.info("PathVariable [userId] =" + userId);
        User user = new User();
        user.setUserId("007");
        user.setUserName("tom");
        user.setPhone("180555555");
        return user;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUserId("007");
        user.setUserName("tom");
        user.setPhone("180555555");
        list.add(user);

        User user1 = new User();
        user1.setUserId("001");
        user1.setUserName("jack");
        user1.setPhone("13333333");
        list.add(user1);
        System.out.println(list.size());
        return list;
    }


    //do get
    @RequestMapping(value = "/user2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser2(@RequestParam("userId") String userId) {
        LOGGER.info("RequestParam[userId] =" + userId);
        User user = new User();
        user.setUserId("007");
        user.setUserName("tom");
        user.setPhone("180555555");
        return user;
    }

    //do post
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean update(@RequestParam("userId") String userId, @RequestParam("userName") String userName) {
        LOGGER.info("update RequestParam[userId] =" + userId + ":[userName]=" + userName);
        User user = new User();
        user.setUserId("007");
        user.setUserName("tom");
        user.setPhone("180555555");
        return true;
    }

    //下载文件
    //http://localhost:9999/user/download?filePath=D:\Helloworld2.PDF&fileName=world.pdf
    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void download(@RequestParam("filePath") String filePath, @RequestParam(value = "fileName",required = false)  String fileName, HttpServletResponse response) {
        try {
            LOGGER.info("filePath=" + filePath);
            Assert.notNull(filePath, "parameter[filePath] is required; it must not be null");
            response.reset();
            response.setContentType("application/x-msdownload;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            File file = new File(filePath);
            //如果文件不存在就返回
            if (!file.exists()) {
                LOGGER.error("file is not exist!");
            }
            if (fileName == null) {
                fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            }
            response.setHeader("Content-Disposition", "attachment; filename="
                    + new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));
            response.setHeader("Connection", "close");
            byte[] b = new byte[4 * 1024];
            try (FileInputStream fi = new FileInputStream(file);
                 ServletOutputStream os = response.getOutputStream()) {
                while (fi.read(b) > 0) {
                    os.write(b);
                    os.flush();
                }
            }
        } catch (Exception e) {
            LOGGER.error("download file failed:" + e);
        }
    }

    @Autowired
    private HttpClientService clientService;
    //test
    @RequestMapping(value = "/testDown", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void test(HttpServletResponse response) throws IOException{
        String url = "http://localhost:9999/user/download";
        //指定修改后文件名
        String fileName = "readme22.pdf";
        //指定文件路径
        String filePath = "D:\\Helloworld2.PDF";
        clientService.download(url,fileName,filePath,response);
    }
}
