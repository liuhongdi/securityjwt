package com.securityjwt.demo.jwt;

import com.securityjwt.demo.pojo.SysUser;
import com.securityjwt.demo.security.SecUser;
import com.securityjwt.demo.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-----loadUserByUsername");
        SysUser oneUser = sysUserService.getOneUserByUsername(username);//数据库查询 看用户是否存在
        String encodedPassword = oneUser.getPassword();
        Collection<GrantedAuthority> collection = new ArrayList<>();//权限集合
        //用户角色role前面要添加ROLE_
        List<String> roles = oneUser.getRoles();
        System.out.println(roles);
        for (String roleone : roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+roleone);
            collection.add(grantedAuthority);
        }
        //给用户增加用户id和昵称
        SecUser user = new SecUser(username,encodedPassword,collection);
        user.setUserid(oneUser.getUserId());
        user.setNickname(oneUser.getNickName());
        return user;
    }
}