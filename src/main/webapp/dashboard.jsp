<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.lifelink.model.BloodInventory" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}

List<BloodInventory> lowStockList =
        (List<BloodInventory>) request.getAttribute("lowStockList");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Admin Dashboard | LifeLink</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="dashboard">

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


    <div class="main-content">

        <div class="page-title">

            <h1>Admin Dashboard</h1>

            <p>
                Monitor and manage the LifeLink blood management system.
            </p>

        </div>


        <!-- STATISTICS -->

        <div class="stats-container">

            <div class="stat-card">

                <p>Total Hospitals</p>

                <h2>
                    <%= request.getAttribute("totalHospitals") %>
                </h2>

            </div>


            <div class="stat-card">

                <p>Total Blood Units</p>

                <h2>
                    <%= request.getAttribute("totalBloodUnits") %>
                </h2>

            </div>


            <div class="stat-card">

                <p>Pending Requests</p>

                <h2>
                    <%= request.getAttribute("pendingRequests") %>
                </h2>

            </div>


            <div class="stat-card">

                <p>Approved Requests</p>

                <h2>
                    <%= request.getAttribute("approvedRequests") %>
                </h2>

            </div>

        </div>


        <!-- LOW STOCK ALERT -->

        <%
        if (lowStockList != null
                && !lowStockList.isEmpty()) {
        %>

        <div class="table-card"
             style="border-left:5px solid #dc2626;">

            <h2 style="color:#dc2626;">
                Low Stock Alert
            </h2>

            <p>
                The following blood groups have 5 or fewer units remaining.
            </p>

            <br>

            <table>

                <tr>

                    <th>Blood Group</th>

                    <th>Available Units</th>

                    <th>Status</th>

                </tr>


                <%
                for (BloodInventory inventory : lowStockList) {
                %>

                <tr>

                    <td>

                        <strong>
                            <%= inventory.getBloodGroup() %>
                        </strong>

                    </td>


                    <td>

                        <%= inventory.getAvailableUnits() %>
                        units

                    </td>


                    <td>

                        <span class="status-rejected">
                            LOW STOCK
                        </span>

                    </td>

                </tr>

                <%
                }
                %>

            </table>


            <br>


            <a href="ViewInventoryServlet"
               class="btn btn-primary">

                Manage Blood Inventory

            </a>

        </div>

        <%
        }
        %>


        <!-- QUICK ACCESS -->

        <div class="table-card">

            <h2>Quick Access</h2>

            <br>

            <a href="ViewBloodRequestsServlet"
               class="btn btn-primary">

                Review Blood Requests

            </a>


            <a href="addHospital.jsp"
               class="btn">

                Add Hospital

            </a>


            <a href="addDonor.jsp"
               class="btn">

                Add Donor

            </a>

        </div>

    </div>

</div>

</body>

</html>