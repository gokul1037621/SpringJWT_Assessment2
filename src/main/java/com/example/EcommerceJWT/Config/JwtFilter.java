package com.example.EcommerceJWT.Config;

import com.example.EcommerceJWT.Service.TokenService;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/*
config file given first priority among other spring beans that will be loaded.
handles the performance of the requests made through http apis such that we can define which requets
need a token and which dont. this also handles the status and processing of http requests and response

 */

@Configuration //first priority among other beans
public class JwtFilter extends GenericFilterBean {
    private TokenService tokenService;
    public JwtFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        String token = httpServletRequest.getHeader("Authorization");
        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return ;
        }
        //specific APIs without token
        if(allowRequestWithoutToken(httpServletRequest)) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req,res);
        }
        else {
            Integer userId = new Integer(tokenService.getUserIdToken(token));
            httpServletRequest.setAttribute("userId", userId);
            filterChain.doFilter(req,res);
        }
    }
    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getRequestURI());
        if(httpServletRequest.getRequestURI().contains("/ecommerceJWT/user"))
            return true;
        else if(httpServletRequest.getRequestURI().contains("/ecommerceJWT/category/getall"))
            return true;
        else if(httpServletRequest.getRequestURI().contains("/ecommerceJWT/category/findbyid"))
            return true;
        else if(httpServletRequest.getRequestURI().contains("/ecommerceJWT/product/getall"))
            return true;
        return false;
    }
}