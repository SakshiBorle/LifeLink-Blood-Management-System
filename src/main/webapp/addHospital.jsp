<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Add Hospital | LifeLink</title>

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

            <h1>Add Hospital</h1>

            <p>
                Register a new hospital with the LifeLink system.
            </p>

        </div>


        <div class="table-card"
             style="max-width:700px;">

            <form action="AddHospitalServlet"
                  method="post">


                <div class="form-group">

                    <label>Hospital Name</label>

                    <input type="text"
                           name="hospitalName"
                           placeholder="Enter hospital name"
                           required>

                </div>


                <div class="form-group">

                    <label>Email</label>

                    <input type="email"
                           name="email"
                           placeholder="Enter hospital email"
                           required>

                </div>


                <div class="form-group">

                    <label>Phone</label>

                    <input type="text"
                           name="phone"
                           placeholder="Enter phone number"
                           required>

                </div>


                <div class="form-group">

                    <label>Address</label>

                    <textarea name="address"
                              rows="4"
                              placeholder="Enter hospital address"
                              required></textarea>

                </div>


                <div class="form-group">

                    <label>Username</label>

                    <input type="text"
                           name="username"
                           placeholder="Create login username"
                           required>

                </div>


                <div class="form-group">

                    <label>Password</label>

                    <input type="password"
                           name="password"
                           placeholder="Create login password"
                           required>

                </div>


                <button type="submit"
                        class="btn btn-primary">

                    Add Hospital

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