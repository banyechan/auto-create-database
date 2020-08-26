package com.banyechan.autocreatedatabase.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Aservlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method =  req.getMethod();
        System.out.println("------- method = " + method);

        String url = req.getRequestURI();
        System.out.println("------- url = " + url);

        String contextPath = req.getContextPath();
        System.out.println("------- contextPath = " + contextPath);

        String servletPath = req.getServletPath();
        System.out.println("------- servletPath = " + servletPath);


        String name = req.getParameter("name");
        System.out.println("------- name = " + name);
        resp.getOutputStream().println("hello world");
    }
}
