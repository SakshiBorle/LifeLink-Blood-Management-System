package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.HospitalDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteHospitalServlet")
public class DeleteHospitalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int hospitalId = Integer.parseInt(
                request.getParameter("id"));

        HospitalDAO dao = new HospitalDAO();

        dao.deleteHospital(hospitalId);

        response.sendRedirect("ViewHospitalsServlet");
    }
}