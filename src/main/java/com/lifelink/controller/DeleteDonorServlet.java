package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.DonorDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteDonorServlet")
public class DeleteDonorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int donorId = Integer.parseInt(
                request.getParameter("id"));

        DonorDAO dao = new DonorDAO();

        dao.deleteDonor(donorId);

        response.sendRedirect("ViewDonorsServlet");
    }
}