package com.securityjwt.demo.service.impl;

import com.securityjwt.demo.mapper.UserMapper;
import com.securityjwt.demo.pojo.SysUser;
import com.securityjwt.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private UserMapper userMapper;
    //根据用户名查询数据库得到用户信息
    @Override
    public SysUser getOneUserByUsername(String username) {
        SysUser user_one = userMapper.selectOneUserByUserName(username);
        return user_one;
    }

}
