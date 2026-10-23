package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.HospitalDAO;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HospitalLoginServlet")
public class HospitalLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HospitalDAO dao = new HospitalDAO();

        Hospital hospital = dao.login(username, password);

        if (hospital != null) {

            HttpSession session = request.getSession();

            session.setAttribute("hospital", hospital);

            response.sendRedirect("hospitalDashboard.jsp");

        } else {

            response.sendRedirect("hospitalLogin.jsp");
        }
    }
}