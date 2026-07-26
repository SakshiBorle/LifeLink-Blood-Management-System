package com.lifelink.controller;

import java.io.IOException;
import java.util.List;

import com.lifelink.dao.BloodRequestDAO;
import com.lifelink.model.BloodRequest;
import com.lifelink.model.Hospital;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HospitalRequestsServlet")
public class HospitalRequestsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Hospital hospital =
                (Hospital) session.getAttribute("hospital");

        if (hospital == null) {
            response.sendRedirect("hospitalLogin.jsp");
            return;
        }

        BloodRequestDAO dao = new BloodRequestDAO();

        List<BloodRequest> requestList =
                dao.getRequestsByHospitalId(
                        hospital.getHospitalId());

        request.setAttribute("requestList", requestList);

        request.getRequestDispatcher("hospitalRequests.jsp")
               .forward(request, response);
    }
}