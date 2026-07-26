package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.DonorDAO;
import com.lifelink.model.Donor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewDonorsServlet")
public class ViewDonorsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        DonorDAO dao = new DonorDAO();

        List<Donor> donorList = dao.getAllDonors();

        request.setAttribute("donorList", donorList);

        request.getRequestDispatcher("donors.jsp")
               .forward(request, response);
    }
}