package com.profitsoft.command.error_page;

import com.profitsoft.command.AbstractCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GotoDefaultErrorCommand extends AbstractCommand {

    private static final String ERROR_JSP = "/WEB-INF/views/error.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardRequest(ERROR_JSP, request, response);
    }
}
