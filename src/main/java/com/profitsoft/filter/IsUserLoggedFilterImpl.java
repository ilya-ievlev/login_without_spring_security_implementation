package com.profitsoft.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsUserLoggedFilterImpl implements Filter {

    private static final String USER_LOGIN = "login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute(USER_LOGIN) != null) {

            chain.doFilter(request, response);
        } else if(session.getAttribute(USER_LOGIN) == null){
            httpResponse.sendRedirect("/");
        }
    }


    @Override
    public void destroy() {

    }
}
