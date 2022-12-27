package com.profitsoft.command.actions;

import com.profitsoft.command.AbstractCommand;
import com.profitsoft.command.util.UserFromRequest;
import com.profitsoft.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUserCommand extends AbstractCommand {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER_LOGIN = "userLogin";
    private static final String DATA_NOT_CORRECT = "dataNotCorrect";
    private static final String LOGIN_PAGE_JSP = "/views/loginPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userLogin = request.getParameter(LOGIN);
        String userPassword = request.getParameter(PASSWORD);
        HttpSession session = request.getSession();
        User user = userDao.getByLogin(userLogin);
        if(user.getUserPassword().equals(userPassword)){
            session.setAttribute(USER_LOGIN, userLogin);
            response.sendRedirect("/secured/helloLoggedUser?id="+user.getUserId());
        } else {
            request.setAttribute(DATA_NOT_CORRECT, true);
            forwardRequest(LOGIN_PAGE_JSP, request, response);
        }
    }
}
