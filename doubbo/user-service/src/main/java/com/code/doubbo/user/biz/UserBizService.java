package com.code.doubbo.user.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.code.doubbo.user.dao.UserDao;
import com.code.doubbo.user.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 16:06
 * @description:
 */

@Service
public class UserBizService {

    @Autowired
    private UserDao userDao;

    public int saveUser(UserBean userBean) {
        return userDao.saveUser(userBean);
    }

    public int updateUser(UserBean userBean) {
        return userDao.updateUser(userBean);
    }

    public int deleteUser(String userId) {
        return userDao.deleteUser(userId);
    }

    public UserBean getUser(String userId) {
        return userDao.getUser(userId);
    }

}
