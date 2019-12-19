package com.qianfeng.market.controller;

import com.qianfeng.market.dao.UserDao;
import com.qianfeng.market.pojo.entity.GoodsType;
import com.qianfeng.market.pojo.entity.User;
import com.qianfeng.market.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * creator：Administrator
 * date:2019/12/16
 */
@Controller
public class IndexController {
    @Resource
    UserDao userDao;

    @Resource
    TypeService typeService;


    @RequestMapping("/")
    String index(Model model) {
        User user = userDao.selectByPrimaryKey(1);
        model.addAttribute("types", typeService.selectTypesByParentId(-1));

        return "index";
    }
    @RequestMapping("/pages/back/dashBoard")
    String dashBoard() {
        return "pages/back/dashBoard";
    }

}
