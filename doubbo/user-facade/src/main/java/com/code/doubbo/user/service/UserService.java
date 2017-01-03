package com.code.doubbo.user.service;

import com.code.doubbo.user.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 14:42
 * @description:
 */

public interface UserService {

    int saveUser(UserBean userBean);

    int updateUser(UserBean userBean);

    int deleteUser(String userId);

    UserBean getUser(String userId);
}
