package com.example.demo;

import com.example.demo.user.User;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {

    private void processRequest(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        if (request.getMethod().equals("POST")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String bio = request.getParameter("bio");
            User u = new User(name, email, pwd, bio);

            String message;
            if (u.validation()) {
                message = "Registered state has been completed";
            } else {
                message = String.join("<br>", u.errors);
            }

            request.getSession().setAttribute("message", message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/register.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }
}