package test.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
//         userclient.saveUser(userBean);
    }

    @Test
    public void updateUser() {
//         userclient.updateUser(userBean);
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
