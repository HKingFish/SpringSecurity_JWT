package com.securityjwtdemo.utils;

import com.securityjwtdemo.entity.security.JwtUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/31
 * @Des:
 */
public class SpringSecurityUtils {
    public static JwtUserDetails getCurrentUser() {
        return (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}