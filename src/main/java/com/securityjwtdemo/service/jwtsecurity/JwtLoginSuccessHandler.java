package com.securityjwtdemo.service.jwtsecurity;

import com.alibaba.fastjson.JSON;
import com.securityjwtdemo.common.Constants;
import com.securityjwtdemo.common.JsonResult;
import com.securityjwtdemo.entity.security.JwtUserDetails;
import com.securityjwtdemo.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/30
 * @Des: 登陆验证成功处理
 */
@Component
public class JwtLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        String json = JSON.toJSONString(jwtUserDetails);
        String jwtToken = JwtUtils.createJwtToken(json, Constants.DEFAULT_TOKEN_TIME_MS);
        //签发token
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setSuccess(jwtToken);
        response.getWriter().write(JSON.toJSONString(jsonResult));
    }
}