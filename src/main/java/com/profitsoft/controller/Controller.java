package com.profitsoft.controller;

import com.profitsoft.command.AbstractCommand;
import com.profitsoft.command.actions.*;
import com.profitsoft.command.error_page.GotoDefaultErrorCommand;
import com.profitsoft.dao.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller extends HttpServlet {
    private static final Map<String, AbstractCommand> STRING_COMMAND_MAP = fillTheCommandMap();
    private final GotoDefaultErrorCommand gotoDefaultErrorCommand = new GotoDefaultErrorCommand();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            STRING_COMMAND_MAP.getOrDefault(request.getRequestURI(), gotoDefaultErrorCommand).execute(request, response);
        } catch (DAOException e) {
            throw new IllegalArgumentException("something wrong with dao", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    private static Map<String, AbstractCommand> fillTheCommandMap(){
        Map<String, AbstractCommand> stringCommandMap = new HashMap<>();
        stringCommandMap.put("/login", new LoginUserCommand());
        stringCommandMap.put("/secured/getUserList", new GetUserListCommand());
        stringCommandMap.put("/logout", new LogoutUserCommand());
        stringCommandMap.put("/secured/helloLoggedUser", new HelloLoggedUserCommand());
        return stringCommandMap;
    }
}
