package com.aaron.controller;

import com.aaron.entity.Exceptions;
import com.aaron.entity.User;
import com.aaron.enums.ResultEnum;
import com.aaron.services.UserService;
import com.aaron.utils.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试mybatis后台读取数据
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUser(id).toString();
    }

    /**
     * 测试tkmybatis后台读取数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * thymeleaf获取数据
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView getAll(Model model) {
        model.addAttribute("userList", userService.getAll());
        model.addAttribute("title","获取所有数据");
        return new ModelAndView("list","userModel",model);
    }

    /**
     * 统一异常处理
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/getError")
    public String GetError() throws Exception {
        Logger businessLogger = LogUtil.getBusinessLogger();
        businessLogger.error("Controller报错啦!");
        throw new Exceptions(ResultEnum.FAIL);
    }
}
