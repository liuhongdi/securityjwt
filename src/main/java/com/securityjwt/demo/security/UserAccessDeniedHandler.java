package com.securityjwt.demo.security;

import com.securityjwt.demo.constant.ResponseCode;
import com.securityjwt.demo.result.RestResult;
import com.securityjwt.demo.util.ServletUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by liuhongdi on 2020/07/13.
 *  拒绝访问
 */
@Component("UserAccessDeniedHandler")
public class UserAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        //当用户在没有授权的情况下访问受保护的REST资源时，将调用此方法发送403 Forbidden响应
        System.out.println("UserAccessDeniedHandler");
        //response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        ServletUtil.printRestResult(RestResult.error(ResponseCode.WEB_403));
    }
}