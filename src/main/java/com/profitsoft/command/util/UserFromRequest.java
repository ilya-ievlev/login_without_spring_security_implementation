package com.profitsoft.command.util;

import com.profitsoft.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserFromRequest {

    public static User createUserFromRequest(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        int userId = Integer.parseInt(request.getParameter("userId"));
        return new User(userId, userLogin, userPassword, userName);
    }
}
