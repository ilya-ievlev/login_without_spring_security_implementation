package com.profitsoft.command.actions;

import com.profitsoft.command.AbstractCommand;
import com.profitsoft.dao.exceptions.DAOException;
import com.profitsoft.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUserListCommand extends AbstractCommand {

    private static final String USER_LIST_JSP = "/WEB-INF/views/userList.jsp";
    private static final String USER_LIST = "userList";
    private static final String USER = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
        int currentUserId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.findById(currentUserId);
        request.setAttribute(USER, user);
        List<User> userList = userDao.findAll();
        request.setAttribute(USER_LIST, userList);
        forwardRequest(USER_LIST_JSP, request, response);
    }
}
