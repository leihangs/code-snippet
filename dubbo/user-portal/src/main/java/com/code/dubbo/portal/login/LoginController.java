package com.code.dubbo.portal.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.code.dubbo.common.entity.UserBean;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 09:46
 * @description:
 */
@Controller
@RequestMapping(value = "/security")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserBizService userBizService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, ModelMap modelMap) {
        return "login/login";
    }

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, ModelMap modelMap) {
        LOGGER.debug("开始登陆.");
        //uid1484556588611 xxxXXXooo
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("password");

        String logHead = "[" + userId + "-" + request.getServletPath() + "] - ";
        LOGGER.info(logHead + " begin login,the userId is [{}],the client ip is [{}]", userId, request.getRemoteAddr());
        LOGGER.debug("验证用户是否存在.");
        if (null == userId) {
            LOGGER.debug("用户不存在，跳转到登陆界面.");
            LOGGER.info(logHead + "userId [{}] doesn't exist.", userId);
            return "redirect:/security/login";
        }
        UserBean user = userBizService.getUser(userId);
        if (user == null) {
            LOGGER.debug("用户不存在，跳转到登陆界面.");
            LOGGER.info(logHead + "userId [{}] doesn't exist.", userId);
            return "redirect:/security/login";
        }
        if (!pwd.equals(user.getPassword())) {
            LOGGER.info("用户密码错误，跳转到登陆界面.");
            return "redirect:/security/login";
        } else {
            LOGGER.info("登录成功");
            return "redirect:/menu/index";
        }
    }
}
