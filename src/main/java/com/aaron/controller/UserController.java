package com.aaron.controller;

import com.aaron.entity.common.Exceptions;
import com.aaron.entity.po.UserInfo;
import com.aaron.enums.ResultEnum;
import com.aaron.services.UserService;
import com.aaron.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author: lfl
 * @description: UserController层
 * @date: Create in 2019/4/21 上午 09:24
 */
@Api(value = "用户接口", description = "用户信息接口")
@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param id
     * @return
     * @description: 测试mybatis后台读取数据
     */
    @ApiOperation(notes = "查询某一用户", value = "用户接口")
    @ResponseBody
    @RequestMapping("/selectOne/{id}")
    @Cacheable(value = "selectOne")
    public UserInfo selectOne(@PathVariable int id) {
        UserInfo user = UserInfo.builder().id(id).build();
        return userService.selectOne(user);
    }

    /**
     * @return
     * @description: 测试tkmybatis后台读取数据
     */
    @ApiOperation(notes = "查询所有用户", value = "用户接口")
    @ResponseBody
    @RequestMapping("/selectAll")
    @Cacheable(value = "selectAll")
    public List<UserInfo> selectAll() {
        return userService.selectAll();
    }

    /**
     * @param model
     * @return
     * @description: thymeleaf获取数据
     */
    @ApiIgnore
    @RequestMapping("/list")
    public ModelAndView selectAll(Model model) {
        model.addAttribute("userList", userService.selectAll());
        model.addAttribute("title", "获取所有数据");
        return new ModelAndView("list", "userModel", model);
    }

    /**
     * @return
     * @throws Exception
     * @description: 统一异常处理
     */
    @ApiIgnore
    @RequestMapping("/getError")
    public String GetError() throws Exception {
        Logger businessLogger = LogUtil.getBusinessLogger();
        businessLogger.error("Controller报错啦!");
        throw new Exceptions(ResultEnum.FAIL);
    }
}
