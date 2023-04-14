package com.aqoo.service.impl;

import com.aqoo.entity.User;
import com.aqoo.mapper.UserMapper;
import com.aqoo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Date
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
