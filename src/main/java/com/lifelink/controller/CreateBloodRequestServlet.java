package com.lifelink.controller;

import java.io.IOException;

import com.lifelink.dao.BloodRequestDAO;
import com.lifelink.model.BloodRequest;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CreateBloodRequestServlet")
public class CreateBloodRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Hospital hospital =
                (Hospital) session.getAttribute("hospital");

        if (hospital == null) {
            response.sendRedirect("hospitalLogin.jsp");
            return;
        }

        BloodRequest bloodRequest = new BloodRequest();

        bloodRequest.setHospitalId(hospital.getHospitalId());

        bloodRequest.setPatientName(
                request.getParameter("patientName"));

        bloodRequest.setBloodGroup(
                request.getParameter("bloodGroup"));

        bloodRequest.setUnitsRequired(
                Integer.parseInt(
                        request.getParameter("unitsRequired")));

        bloodRequest.setEmergencyLevel(
                request.getParameter("emergencyLevel"));

        bloodRequest.setReason(
                request.getParameter("reason"));

        BloodRequestDAO dao = new BloodRequestDAO();

        boolean status = dao.addRequest(bloodRequest);

        if (status) {
            response.sendRedirect("hospitalDashboard.jsp");
        } else {
            response.sendRedirect("createBloodRequest.jsp");
        }
    }
}