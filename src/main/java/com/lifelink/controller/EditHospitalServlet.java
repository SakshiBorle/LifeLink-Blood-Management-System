package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.HospitalDAO;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditHospitalServlet")
public class EditHospitalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int hospitalId = Integer.parseInt(
                request.getParameter("id"));

        HospitalDAO dao = new HospitalDAO();

        Hospital hospital = dao.getHospitalById(hospitalId);

        request.setAttribute("hospital", hospital);

        request.getRequestDispatcher("editHospital.jsp")
               .forward(request, response);
    }
}