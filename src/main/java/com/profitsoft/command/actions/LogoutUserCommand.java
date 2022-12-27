package com.profitsoft.command.actions;

import com.profitsoft.command.AbstractCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutUserCommand extends AbstractCommand {

    private static final String LOGIN_PAGE_JSP = "/views/loginPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        forwardRequest(LOGIN_PAGE_JSP, request, response);
    }
}
