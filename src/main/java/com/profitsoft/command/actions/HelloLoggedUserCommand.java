package com.profitsoft.command.actions;

import com.profitsoft.command.AbstractCommand;
import com.profitsoft.dao.exceptions.DAOException;
import com.profitsoft.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloLoggedUserCommand extends AbstractCommand {

    private static final String HELLO_PAGE_LOGGED_USER_JSP = "/WEB-INF/views/helloPageLoggedUser.jsp";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
        int userId = Integer.parseInt(request.getParameter(ID));
        User user = userDao.findById(userId);
        request.setAttribute(USER, user);
        forwardRequest(HELLO_PAGE_LOGGED_USER_JSP, request, response);
    }
}
