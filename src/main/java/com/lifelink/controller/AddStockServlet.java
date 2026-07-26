package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.BloodInventoryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStockServlet")
public class AddStockServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int inventoryId = Integer.parseInt(
                request.getParameter("inventoryId"));

        int units = Integer.parseInt(
                request.getParameter("units"));

        BloodInventoryDAO dao = new BloodInventoryDAO();

        dao.addStock(inventoryId, units);

        response.sendRedirect("ViewInventoryServlet");
    }
}