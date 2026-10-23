package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.HospitalDAO;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateHospitalServlet")
public class UpdateHospitalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int hospitalId = Integer.parseInt(
                request.getParameter("hospitalId"));

        Hospital hospital = new Hospital();

        hospital.setHospitalId(hospitalId);
        hospital.setHospitalName(
                request.getParameter("hospitalName"));
        hospital.setEmail(
                request.getParameter("email"));
        hospital.setPhone(
                request.getParameter("phone"));
        hospital.setAddress(
                request.getParameter("address"));
        hospital.setUsername(
                request.getParameter("username"));
        hospital.setPassword(
                request.getParameter("password"));

        HospitalDAO dao = new HospitalDAO();

        dao.updateHospital(hospital);

        response.sendRedirect("ViewHospitalsServlet");
    }
}