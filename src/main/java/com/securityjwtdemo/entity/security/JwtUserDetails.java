package com.securityjwtdemo.entity.security;

import com.securityjwtdemo.entity.ElstRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/30
 * @Des:
 */
public class JwtUserDetails implements UserDetails {
    private Integer id;

    private String userId;

    private String userName;

    private String userPwd;

    private Short userEnabled;

    private List<ElstRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Short getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(Short userEnabled) {
        this.userEnabled = userEnabled;
    }

    public List<ElstRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ElstRole> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles == null ? new ArrayList<SimpleGrantedAuthority>() : roles.stream().map(r ->new SimpleGrantedAuthority(r.getRoleId())).collect(Collectors.toList());
    }

    @Override

    public String getPassword() {
        return this.userPwd;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return 1 == userEnabled;
    }
}