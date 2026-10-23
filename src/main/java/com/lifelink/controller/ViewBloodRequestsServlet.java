package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.BloodRequestDAO;
import com.lifelink.model.BloodRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewBloodRequestsServlet")
public class ViewBloodRequestsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BloodRequestDAO dao = new BloodRequestDAO();

        List<BloodRequest> requestList =
                dao.getAllRequests();

        request.setAttribute("requestList", requestList);

        request.getRequestDispatcher("bloodRequests.jsp")
               .forward(request, response);
    }
}