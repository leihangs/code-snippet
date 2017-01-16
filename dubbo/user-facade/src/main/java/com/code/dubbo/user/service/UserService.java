package com.code.dubbo.user.service;

import com.code.dubbo.user.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 14:42
 * @description:
 */

public interface UserService {

    int saveUser(UserBean userBean);

    int updateUser(UserBean userBean);

    int deleteUser(String operId);

    UserBean getUser(String operId);
}
