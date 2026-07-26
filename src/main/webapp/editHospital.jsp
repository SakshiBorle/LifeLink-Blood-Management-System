<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.lifelink.model.Hospital" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}

Hospital hospital =
        (Hospital) request.getAttribute("hospital");

if (hospital == null) {
    response.sendRedirect("ViewHospitalsServlet");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Edit Hospital | LifeLink</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="dashboard">

    <!-- SIDEBAR -->

    <div class="sidebar">

        <h1 class="sidebar-logo">LifeLink</h1>

        <a href="DashboardServlet">Dashboard</a>
        <a href="ViewHospitalsServlet">Hospitals</a>
        <a href="ViewInventoryServlet">Blood Inventory</a>
        <a href="ViewBloodRequestsServlet">Blood Requests</a>
        <a href="ViewDonorsServlet">Donor Management</a>
        <a href="ReportsServlet">Reports</a>
        <a href="LogoutServlet">Logout</a>

    </div>


    <!-- MAIN CONTENT -->

    <div class="main-content">

        <div class="page-title">

            <h1>Edit Hospital</h1>

            <p>
                Update hospital information and login details.
            </p>

        </div>


        <div class="table-card"
             style="max-width:700px;">

            <form action="UpdateHospitalServlet"
                  method="post">


                <input type="hidden"
                       name="hospitalId"
                       value="<%= hospital.getHospitalId() %>">


                <div class="form-group">

                    <label>Hospital Name</label>

                    <input type="text"
                           name="hospitalName"
                           value="<%= hospital.getHospitalName() %>"
                           required>

                </div>


                <div class="form-group">

                    <label>Email</label>

                    <input type="email"
                           name="email"
                           value="<%= hospital.getEmail() %>"
                           required>

                </div>


                <div class="form-group">

                    <label>Phone</label>

                    <input type="text"
                           name="phone"
                           value="<%= hospital.getPhone() %>"
                           required>

                </div>


                <div class="form-group">

                    <label>Address</label>

                    <textarea name="address"
                              rows="4"
                              required><%= hospital.getAddress() %></textarea>

                </div>


                <div class="form-group">

                    <label>Username</label>

                    <input type="text"
                           name="username"
                           value="<%= hospital.getUsername() %>"
                           required>

                </div>


                <div class="form-group">

                    <label>Password</label>

                    <input type="password"
                           name="password"
                           value="<%= hospital.getPassword() %>"
                           required>

                </div>


                <button type="submit"
                        class="btn btn-primary">

                    Update Hospital

                </button>


                <a href="ViewHospitalsServlet"
                   class="btn">

                    Cancel

                </a>

            </form>

        </div>

    </div>

</div>

</body>

</html>