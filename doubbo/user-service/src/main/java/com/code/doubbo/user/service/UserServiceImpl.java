package com.code.doubbo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.doubbo.user.biz.UserBizService;
import com.code.doubbo.user.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 14:43
 * @description:
 */

@Component("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBizService userBizService;

    public int saveUser(UserBean userBean) {
        return userBizService.saveUser(userBean);
    }

    public int updateUser(UserBean userBean) {
        return userBizService.updateUser(userBean);
    }

    public int deleteUser(String userId) {
        return userBizService.deleteUser(userId);
    }

    public UserBean getUser(String userId) {
        return userBizService.getUser(userId);
    }

}
