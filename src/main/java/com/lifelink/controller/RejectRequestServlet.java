package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.BloodRequestDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RejectRequestServlet")
public class RejectRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int requestId = Integer.parseInt(
                request.getParameter("id"));

        BloodRequestDAO dao = new BloodRequestDAO();

        dao.rejectRequest(requestId);

        response.sendRedirect("ViewBloodRequestsServlet");
    }
}