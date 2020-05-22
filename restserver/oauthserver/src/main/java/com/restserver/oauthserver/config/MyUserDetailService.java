package com.restserver.oauthserver.config;

import com.restserver.oauthserver.domain.Role;
import com.restserver.oauthserver.domain.UserInfo;
import com.restserver.oauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserInfo userInfo=userService.getUserInfoById(userId);
        if(userInfo==null){
            throw new UsernameNotFoundException("用户名："+ userId + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<Role> iterator =  userInfo.getRole().iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next().getCourseId()));
        }
        return new org.springframework.security.core.userdetails.User(userInfo.getUserId(),userInfo.getPassword(),collection);
    }
}
