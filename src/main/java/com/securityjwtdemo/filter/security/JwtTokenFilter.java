package com.securityjwtdemo.filter.security;

import com.alibaba.fastjson.JSON;
import com.securityjwtdemo.common.JsonResponseStatus;
import com.securityjwtdemo.common.JsonResult;
import com.securityjwtdemo.entity.security.JwtLoginToken;
import com.securityjwtdemo.entity.security.JwtUserDetails;
import com.securityjwtdemo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/30
 * @Des: Token有效性验证拦截器
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = httpServletRequest.getHeader("Authentication");
            if (StringUtils.isEmpty(token)) {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                JsonResult<String> jsonResult = new JsonResult<>();
                jsonResult.setFail(JsonResponseStatus.TokenFail.getCode(), "未登录");
                httpServletResponse.getWriter().write(JSON.toJSONString(jsonResult));
                return;
            }

            Claims claims = JwtUtils.parseJWT(token);
            if (JwtUtils.isTokenExpired(claims)) {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                JsonResult<String> jsonResult = new JsonResult<>();
                jsonResult.setFail(JsonResponseStatus.TokenFail.getCode(), "登陆失效，请重新登陆");
                httpServletResponse.getWriter().write(JSON.toJSONString(jsonResult));
                return;
            }

            JwtUserDetails user = JSON.parseObject(claims.get("userDetails", String.class), JwtUserDetails.class);
            JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
            jwtLoginToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("登陆凭证失效，请重新登陆");
        }

    }

}