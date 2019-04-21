package com.aaron.entity.common;

import com.aaron.enums.ResultEnum;
import lombok.Data;

/**
 * @author: lfl
 * @description: Exceptions实体类
 */
@Data
public class Exceptions extends RuntimeException {

    private Integer code;

    public Exceptions(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
