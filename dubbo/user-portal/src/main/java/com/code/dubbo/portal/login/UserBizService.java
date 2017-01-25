package com.code.dubbo.portal.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dubbo.common.entity.UserBean;
import com.code.dubbo.common.service.UserService;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 09:53
 * @description:
 */
@Service
public class UserBizService {
    @Autowired
    UserService userService;

    public UserBean getUser(String userId){
        return userService.getUser(userId);
    }
}
