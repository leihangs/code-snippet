package com.code.dubbo.portal.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: leihang@live.cn
 * @date: 2017-01-17 10:03
 * @description:
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String init() {
        return "menu/dashborad";
    }
}
