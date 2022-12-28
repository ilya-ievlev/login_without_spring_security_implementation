package com.profitsoft.command.actions;

import com.profitsoft.command.AbstractCommand;
import com.profitsoft.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUserCommand extends AbstractCommand {
    private static final String DATA_NOT_CORRECT = "dataNotCorrect";
    private static final String LOGIN_PAGE_JSP = "/views/loginPage.jsp";
    private static final String SECURED_HELLO_LOGGED_USER_ID = "/secured/helloLoggedUser?id=";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userLogin = request.getParameter(LOGIN);
        String userPassword = request.getParameter(PASSWORD);
        HttpSession session = request.getSession();
        User user = userDao.getByLogin(userLogin);
        if(user.getPassword().equals(userPassword)){
            session.setAttribute(LOGIN, userLogin);
            response.sendRedirect(SECURED_HELLO_LOGGED_USER_ID +user.getId());
        } else {
            request.setAttribute(DATA_NOT_CORRECT, true);
            forwardRequest(LOGIN_PAGE_JSP, request, response);
        }
    }
}
