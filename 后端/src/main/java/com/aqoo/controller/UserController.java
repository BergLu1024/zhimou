package com.aqoo.controller;

import com.aqoo.common.R;
import com.aqoo.entity.User;
import com.aqoo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description
 * @Date
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public R<String> addUser(@RequestBody User user) {
        userService.save(user);
        return R.success("用户添加成功");
    }

    @DeleteMapping
    public R<String> deleteUser(@PathVariable Integer id) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, id);
        userService.remove(lambdaQueryWrapper);
        return R.success("删除成功");
    }

    @PostMapping("/login")
    public R<String> login(@RequestBody User user, HttpServletRequest request) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User one = userService.getOne(wrapper);
        if (one == null) {
            return R.error("用户不存在");
        }

        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        if (!one.getPassword().equals(password)) {
            return R.error("密码错误");
        }

        request.getSession().setAttribute("user", user.getId());

        return R.success("登录成功");

    }

    @PostMapping("/logout")
    public R<String> logout(@RequestBody Integer id, HttpServletRequest request) {

        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }


}
