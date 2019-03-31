package com.aaron.controller;

import com.aaron.entity.Exceptions;
import com.aaron.entity.User;
import com.aaron.enums.ResultEnum;
import com.aaron.services.UserService;
import com.aaron.utils.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    // 测试mybatis后台读取数据
    @ResponseBody
    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUser(id).toString();
    }

    // 测试tkmybatis后台读取数据
    @ResponseBody
    @RequestMapping("getAll")
    public List<User> getAll(@PathVariable int id) {
        return userService.getAll();
    }

    // 统一异常处理
    @RequestMapping("/getError")
    public String GetError() throws Exception {
        Logger log1 = LogUtil.getBussinessLogger();
        log1.error("Controller报错啦!");
        throw new Exceptions(ResultEnum.FAIL);
    }
}
