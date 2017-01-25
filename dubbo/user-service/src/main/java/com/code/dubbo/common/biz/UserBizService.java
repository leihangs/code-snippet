package com.code.dubbo.common.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dubbo.common.dao.UserDao;
import com.code.dubbo.common.entity.UserBean;

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

    public int deleteUser(String operId) {
        return userDao.deleteUser(operId);
    }

    public UserBean getUser(String operId) {
        return userDao.getUser(operId);
    }

}
