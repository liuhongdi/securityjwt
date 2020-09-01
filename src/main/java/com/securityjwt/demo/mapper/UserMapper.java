package com.securityjwt.demo.mapper;

import com.securityjwt.demo.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public SysUser selectOneUserByUserName(String username);
}