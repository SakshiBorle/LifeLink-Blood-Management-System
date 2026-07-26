<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.lifelink.model.Hospital" %>

<%
Hospital hospital =
        (Hospital) session.getAttribute("hospital");

if (hospital == null) {
    response.sendRedirect("hospitalLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Hospital Dashboard | LifeLink</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="dashboard">

    <div class="sidebar">

        <h1 class="sidebar-logo">LifeLink</h1>

        <a href="hospitalDashboard.jsp">
            Dashboard
        </a>

        <a href="createBloodRequest.jsp">
            Create Blood Request
        </a>

        <a href="HospitalRequestsServlet">
            My Blood Requests
        </a>

        <a href="HospitalLogoutServlet">
            Logout
        </a>

    </div>


    <div class="main-content">

        <div class="page-title">

            <h1>Hospital Dashboard</h1>

            <p>
                Welcome, <%= hospital.getHospitalName() %>
            </p>

        </div>


        <div class="stats-container">

            <div class="stat-card">

                <p>Hospital</p>

                <h2>
                    <%= hospital.getHospitalName() %>
                </h2>

            </div>


        </div>


        <div class="table-card">

            <h2>Quick Actions</h2>

            <br>

            <a href="createBloodRequest.jsp"
               class="btn btn-primary">

                Create Blood Request

            </a>

            <a href="HospitalRequestsServlet"
               class="btn">

                View My Requests

            </a>

        </div>

    </div>

</div>

</body>

</html>