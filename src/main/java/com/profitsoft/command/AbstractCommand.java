package com.profitsoft.command;

import com.profitsoft.dao.exceptions.DAOException;
import com.profitsoft.dao.impl.UserDaoImpl;
import com.profitsoft.dao.interfaces.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand {
    protected UserDao userDao = new UserDaoImpl();

    protected static final String ID = "id";
    protected static final String USER = "user";
    protected static final String LOGIN = "login";
    protected static final String PASSWORD = "password";

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException;

    protected void forwardRequest(String jspPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jspPath);
        requestDispatcher.forward(request, response);
    }
}
