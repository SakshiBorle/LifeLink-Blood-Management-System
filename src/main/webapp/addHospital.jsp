```jsp
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
            <p>Register a new hospital with the LifeLink system.</p>
        </div>

        <div class="table-card" style="max-width: 700px;">

            <form action="AddHospitalServlet"
                  method="post"
                  autocomplete="off">

                <div class="form-group">
                    <label for="hospitalName">Hospital Name</label>
                    <input type="text"
                           id="hospitalName"
                           name="hospitalName"
                           placeholder="Enter hospital name"
                           autocomplete="organization"
                           required>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email"
                           id="email"
                           name="email"
                           placeholder="Enter hospital email"
                           autocomplete="off"
                           required>
                </div>

                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text"
                           id="phone"
                           name="phone"
                           placeholder="Enter phone number"
                           autocomplete="off"
                           required>
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <textarea id="address"
                              name="address"
                              rows="4"
                              placeholder="Enter hospital address"
                              autocomplete="off"
                              required></textarea>
                </div>

                <div class="form-group">
                    <label for="username">Hospital Username</label>
                    <input type="text"
                           id="username"
                           name="username"
                           placeholder="Create hospital username"
                           autocomplete="off"
                           required>
                </div>

                <div class="form-group">
                    <label for="password">Hospital Password</label>
                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Create hospital password"
                           autocomplete="new-password"
                           required>
                </div>

                <button type="submit" class="btn btn-primary">
                    Add Hospital
                </button>

                <a href="ViewHospitalsServlet" class="btn">
                    Cancel
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>
```