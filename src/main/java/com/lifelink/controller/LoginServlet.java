package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.AdminDAO;
import com.lifelink.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO dao = new AdminDAO();

        Admin admin = dao.login(username, password);

        if (admin != null) {

            HttpSession session = request.getSession();

            session.setAttribute("admin", admin);

            response.sendRedirect("DashboardServlet");

        } else {

            response.sendRedirect("login.jsp");

        }

    }
}
