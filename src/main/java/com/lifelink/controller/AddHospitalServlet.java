package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.HospitalDAO;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddHospitalServlet")
public class AddHospitalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Hospital hospital = new Hospital();

        hospital.setHospitalName(request.getParameter("hospitalName"));
        hospital.setEmail(request.getParameter("email"));
        hospital.setPhone(request.getParameter("phone"));
        hospital.setAddress(request.getParameter("address"));
        hospital.setUsername(request.getParameter("username"));
        hospital.setPassword(request.getParameter("password"));

        HospitalDAO dao = new HospitalDAO();

        boolean status = dao.addHospital(hospital);

        if (status) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("addHospital.jsp");
        }
    }
}