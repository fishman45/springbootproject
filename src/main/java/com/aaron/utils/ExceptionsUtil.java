package com.aaron.utils;

import com.aaron.entity.common.Exceptions;
import com.aaron.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lfl
 * @description: 统一异常处理类
 */
@ControllerAdvice
public class ExceptionsUtil {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map AllErrorHandler(Exception e) {
        Map map = new HashMap();
        map.put("code", -1);
        map.put("msg", ResultEnum.UN_KNOW_ERROR);
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = Exceptions.class)
    public Map CustomErrorHandler(Exceptions e) {
        Map map = new HashMap();
        map.put("code", e.getCode());
        map.put("msg", e.getMessage());
        return map;
    }
}
