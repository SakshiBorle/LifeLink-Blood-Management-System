package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.DashboardDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReportsServlet")
public class ReportsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        DashboardDAO dao = new DashboardDAO();

        request.setAttribute(
                "totalHospitals",
                dao.getTotalHospitals());

        request.setAttribute(
                "totalDonors",
                dao.getTotalDonors());

        request.setAttribute(
                "totalBloodUnits",
                dao.getTotalBloodUnits());

        request.setAttribute(
                "pendingRequests",
                dao.getPendingRequests());

        request.setAttribute(
                "approvedRequests",
                dao.getApprovedRequests());

        request.setAttribute(
                "rejectedRequests",
                dao.getRejectedRequests());

        request.getRequestDispatcher("reports.jsp")
               .forward(request, response);
    }
}