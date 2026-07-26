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

<title>Add Donor | LifeLink</title>

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

            <h1>Add Donor</h1>

            <p>
                Register a new blood donor in the LifeLink system.
            </p>

        </div>


        <div class="table-card"
             style="max-width:700px;">

            <form action="AddDonorServlet"
                  method="post">


                <div class="form-group">

                    <label>Donor Name</label>

                    <input type="text"
                           name="donorName"
                           placeholder="Enter donor name"
                           required>

                </div>


                <div class="form-group">

                    <label>Blood Group</label>

                    <select name="bloodGroup"
                            required>

                        <option value="">
                            Select blood group
                        </option>

                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>

                    </select>

                </div>


                <div class="form-group">

                    <label>Age</label>

                    <input type="number"
                           name="age"
                           min="18"
                           placeholder="Enter donor age"
                           required>

                </div>


                <div class="form-group">

                    <label>Gender</label>

                    <select name="gender"
                            required>

                        <option value="">
                            Select gender
                        </option>

                        <option value="Male">Male</option>

                        <option value="Female">
                            Female
                        </option>

                        <option value="Other">
                            Other
                        </option>

                    </select>

                </div>


                <div class="form-group">

                    <label>Phone</label>

                    <input type="text"
                           name="phone"
                           placeholder="Enter phone number"
                           required>

                </div>


                <div class="form-group">

                    <label>Last Donation Date</label>

                    <input type="date"
                           name="lastDonation"
                           required>

                </div>


                <button type="submit"
                        class="btn btn-primary">

                    Add Donor

                </button>


                <a href="ViewDonorsServlet"
                   class="btn">

                    Cancel

                </a>

            </form>

        </div>

    </div>

</div>

</body>

</html>