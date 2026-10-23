package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.BloodInventoryDAO;
import com.lifelink.dao.DashboardDAO;
import com.lifelink.model.BloodInventory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        DashboardDAO dashboardDAO = new DashboardDAO();

        int totalHospitals =
                dashboardDAO.getTotalHospitals();

        int totalBloodUnits =
                dashboardDAO.getTotalBloodUnits();

        int pendingRequests =
                dashboardDAO.getPendingRequests();

        int approvedRequests =
                dashboardDAO.getApprovedRequests();

        BloodInventoryDAO bloodInventoryDAO =
                new BloodInventoryDAO();

        List<BloodInventory> lowStockList =bloodInventoryDAO.getLowStockInventory();

        request.setAttribute(
                "totalHospitals",
                totalHospitals);

        request.setAttribute(
                "totalBloodUnits",
                totalBloodUnits);

        request.setAttribute(
                "pendingRequests",
                pendingRequests);

        request.setAttribute(
                "approvedRequests",
                approvedRequests);

        request.setAttribute(
                "lowStockList",
                lowStockList);

        request.getRequestDispatcher("/dashboard.jsp")
               .forward(request, response);
    }
}