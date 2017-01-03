package com.code.doubbo.user.dao;

import com.code.doubbo.user.entity.UserBean;
import org.apache.ibatis.annotations.Param;

/**
 * @author: leihang@live.cn
 * @date: 2016-12-30 16:21
 * @description:
 */

public interface UserDao {

    int saveUser(UserBean userBean);

    int updateUser(UserBean userBean);

    int deleteUser(@Param("userId") String userId);

    UserBean getUser(@Param("userId") String userId);


}
