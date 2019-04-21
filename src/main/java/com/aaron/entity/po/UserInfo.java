package com.aaron.entity.po;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: lfl
 * @descriptino: 用户实体类
 */
@Data
@Builder
@Table(name = "user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String passWord;

    private String realName;
}
