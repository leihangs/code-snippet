package test.user;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.code.doubbo.user.entity.UserBean;
import com.code.doubbo.user.service.UserService;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 16:15
 * @description:服务消费者，测试使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:doubbo-consumer.xml"})
public class UserServiceTest {

    @Autowired
    UserService userClient;

    @Test
    public void saveUser() {
        UserBean userBean = new UserBean();
//        userBean.setUserId("uid" + new Date().getTime());
        userBean.setUserId("uid1");
        userBean.setUserName("opera");
        userBean.setPassword("xxxXXXooo");
        userBean.setEmail("support@163.com");
        userBean.setPhone("15201234567");
        userClient.saveUser(userBean);
    }

    @Test
    public void updateUser() {
        UserBean userBean = new UserBean();
        userBean.setUserId("uid1");
        userBean.setUserName("opera2");
        userBean.setPassword("xxxXXXooo2");
        userBean.setEmail("service@163.com");
        userBean.setPhone("18501234567");
        userClient.updateUser(userBean);
    }

    @Test
    public void deleteUser() {
        String userId = "001";
        userClient.deleteUser(userId);
    }

    @Test
    public void getUser() {
        String userId = "001";
        userClient.getUser(userId);
    }
}
