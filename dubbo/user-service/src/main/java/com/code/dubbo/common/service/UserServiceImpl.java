package com.code.dubbo.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.dubbo.common.biz.UserBizService;
import com.code.dubbo.common.entity.UserBean;

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

    public int deleteUser(String operId) {
        return userBizService.deleteUser(operId);
    }

    public UserBean getUser(String operId) {
        return userBizService.getUser(operId);
    }

}
