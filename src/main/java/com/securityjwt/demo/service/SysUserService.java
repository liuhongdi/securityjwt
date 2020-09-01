package com.securityjwt.demo.service;

import com.securityjwt.demo.pojo.SysUser;

public interface SysUserService {
    public SysUser getOneUserByUsername(String Username);
}
