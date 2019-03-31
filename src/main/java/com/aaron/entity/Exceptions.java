package com.aaron.entity;

import com.aaron.enums.ResultEnum;
import lombok.Data;

@Data
public class Exceptions extends RuntimeException {

    private Integer code;

    public Exceptions(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
