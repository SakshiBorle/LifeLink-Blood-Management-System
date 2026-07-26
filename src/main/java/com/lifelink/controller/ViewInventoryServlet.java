package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.BloodInventoryDAO;
import com.lifelink.model.BloodInventory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewInventoryServlet")
public class ViewInventoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BloodInventoryDAO dao = new BloodInventoryDAO();

        List<BloodInventory> inventoryList =
                dao.getAllInventory();

        request.setAttribute("inventoryList", inventoryList);

        request.getRequestDispatcher("inventory.jsp")
               .forward(request, response);
    }
    
}