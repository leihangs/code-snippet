package test.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.code.dubbo.user.entity.UserBean;
import com.code.dubbo.user.service.UserService;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-03 16:15
 * @description:服务消费者，测试使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dubbo-consumer.xml"})
public class UserServiceTest {

    @Autowired
    UserService userClient;

    @Test
    public void saveUser() {
        UserBean userBean = new UserBean();
        userBean.setOperId("uid1");
        userBean.setOperName("opera");
        userBean.setPassword("xxxXXXooo");
        userBean.setEmail("support@163.com");
        userBean.setPhone("15201234567");
        Assert.isTrue(userClient.saveUser(userBean)==1);
    }

    @Test
    public void updateUser() {
        UserBean userBean = new UserBean();
        userBean.setOperId("uid1");
        userBean.setOperName("opera2");
        userBean.setPassword("xxxXXXooo2");
        userBean.setEmail("service@163.com");
        userBean.setPhone("18501234567");
        Assert.isTrue(userClient.updateUser(userBean)==1);
    }

    @Test
    public void getUser() {
        String operId = "uid1";
        UserBean user = userClient.getUser(operId);
        System.out.println("getUser="+user.toString());
        Assert.isTrue(operId.equals(user.getOperId()));
    }

    @Test
    public void deleteUser() {
        String operId = "uid1";
        Assert.isTrue(userClient.deleteUser(operId) == 1);
    }

}
