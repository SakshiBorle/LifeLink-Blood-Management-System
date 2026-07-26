package com.lifelink.controller;

import java.io.IOException;
import java.sql.Date;

import com.lifelink.dao.DonorDAO;
import com.lifelink.model.Donor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddDonorServlet")
public class AddDonorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Donor donor = new Donor();

        donor.setDonorName(
                request.getParameter("donorName"));

        donor.setBloodGroup(
                request.getParameter("bloodGroup"));

        donor.setAge(
                Integer.parseInt(request.getParameter("age")));

        donor.setGender(
                request.getParameter("gender"));

        donor.setPhone(
                request.getParameter("phone"));

        donor.setLastDonation(
                Date.valueOf(request.getParameter("lastDonation")));

        DonorDAO dao = new DonorDAO();

        boolean status = dao.addDonor(donor);

        if (status) {
            response.sendRedirect("ViewDonorsServlet");
        } else {
            response.sendRedirect("addDonor.jsp");
        }
    }
}