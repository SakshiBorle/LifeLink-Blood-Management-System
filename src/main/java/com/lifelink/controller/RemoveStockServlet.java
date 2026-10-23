package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.BloodInventoryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RemoveStockServlet")
public class RemoveStockServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int inventoryId = Integer.parseInt(
                request.getParameter("inventoryId"));

        int units = Integer.parseInt(
                request.getParameter("units"));

        BloodInventoryDAO dao = new BloodInventoryDAO();

        dao.removeStock(inventoryId, units);

        response.sendRedirect("ViewInventoryServlet");
    }
}