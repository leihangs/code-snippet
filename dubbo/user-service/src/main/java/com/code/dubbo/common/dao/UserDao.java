package com.code.dubbo.common.dao;

import com.code.dubbo.common.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2016-12-30 16:21
 * @description:
 */

public interface UserDao {

    int saveUser(UserBean userBean);

    int updateUser(UserBean userBean);

    int deleteUser(String operId);

    UserBean getUser(String operId);

}
