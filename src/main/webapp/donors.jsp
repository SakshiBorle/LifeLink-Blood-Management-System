<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.lifelink.model.Donor" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}

List<Donor> donorList =
        (List<Donor>) request.getAttribute("donorList");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Donor Management | LifeLink</title>

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

            <h1>Donor Management</h1>

            <p>
                Manage registered blood donors in the LifeLink system.
            </p>

        </div>


        <a href="addDonor.jsp"
           class="btn btn-primary">

            Add Donor

        </a>


        <div class="table-card">

            <table>

                <tr>

                    <th>Donor ID</th>

                    <th>Donor Name</th>

                    <th>Blood Group</th>

                    <th>Age</th>

                    <th>Gender</th>

                    <th>Phone</th>

                    <th>Last Donation</th>

                    <th>Action</th>

                </tr>


                <%
                if (donorList != null
                        && !donorList.isEmpty()) {

                    for (Donor donor : donorList) {
                %>


                <tr>

                    <td>
                        <%= donor.getDonorId() %>
                    </td>


                    <td>

                        <strong>
                            <%= donor.getDonorName() %>
                        </strong>

                    </td>


                    <td>

                        <strong>
                            <%= donor.getBloodGroup() %>
                        </strong>

                    </td>


                    <td>
                        <%= donor.getAge() %>
                    </td>


                    <td>
                        <%= donor.getGender() %>
                    </td>


                    <td>
                        <%= donor.getPhone() %>
                    </td>


                    <td>
                        <%= donor.getLastDonation() %>
                    </td>


                    <td>

                        <a href="DeleteDonorServlet?id=<%= donor.getDonorId() %>"
                           class="btn"
                           onclick="return confirm('Are you sure you want to delete this donor?');">

                            Delete

                        </a>

                    </td>

                </tr>


                <%
                    }

                } else {
                %>


                <tr>

                    <td colspan="8"
                        style="text-align:center;
                               padding:30px;">

                        No donors found.

                    </td>

                </tr>


                <%
                }
                %>


            </table>

        </div>

    </div>

</div>

</body>

</html>