package com.aqoo.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Date 2023/4/11 14:06
 * @Version 1.0
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer status;
}
