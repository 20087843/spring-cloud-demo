package cn.pri.smilly.authservice.services.impl;

import cn.pri.smilly.authservice.mapper.PermissionMapper;
import cn.pri.smilly.authservice.mapper.RoleMapper;
import cn.pri.smilly.authservice.mapper.UserMapper;
import cn.pri.smilly.commonservice.bean.po.MenuPo;
import cn.pri.smilly.commonservice.bean.po.RolePo;
import cn.pri.smilly.commonservice.bean.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserPo user = userMapper.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<RolePo> roleList = roleMapper.getRoleByUserId(user.getId());
        if (!CollectionUtils.isEmpty(roleList)) {
            for (RolePo role : roleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
                grantedAuthorities.add(grantedAuthority);
                List<MenuPo> permissionList = permissionMapper.getRolePermission(role.getId());
                if (!CollectionUtils.isEmpty(permissionList)) {
                    for (MenuPo menu : permissionList) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(grantedAuthorities)
                .accountExpired(true)
                .disabled(true)
                .credentialsExpired(true)
                .accountLocked(true)
                .build();
    }
}