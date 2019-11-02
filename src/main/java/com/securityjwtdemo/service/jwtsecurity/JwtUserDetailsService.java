package com.securityjwtdemo.service.jwtsecurity;

import com.securityjwtdemo.dao.ElstUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/30
 * @Des:
 */
@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private ElstUserMapper elstUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return elstUserMapper.loadUserByUsername(username);
    }
}