package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.HospitalDAO;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewHospitalsServlet")
public class ViewHospitalsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HospitalDAO dao = new HospitalDAO();

        List<Hospital> hospitals = dao.getAllHospitals();

        request.setAttribute("hospitals", hospitals);

        request.getRequestDispatcher("hospitals.jsp")
               .forward(request, response);
    }
}