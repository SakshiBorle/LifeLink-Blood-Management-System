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

<title>Reports | LifeLink</title>

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

            <h1>LifeLink Reports</h1>

            <p>
                View an overview of blood inventory and system activity.
            </p>

        </div>


        <!-- SUMMARY CARDS -->

        <div class="stats-container">

            <div class="stat-card">

                <p>Total Hospitals</p>

                <h2>
                    <%= request.getAttribute("totalHospitals") %>
                </h2>

            </div>


            <div class="stat-card">

                <p>Total Donors</p>

                <h2>
                    <%= request.getAttribute("totalDonors") %>
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

                <h2 class="status-pending">
                    <%= request.getAttribute("pendingRequests") %>
                </h2>

            </div>

        </div>


        <!-- REQUEST SUMMARY -->

        <div class="table-card">

            <h2>Blood Request Summary</h2>

            <br>

            <table>

                <tr>

                    <th>Request Status</th>

                    <th>Total Requests</th>

                </tr>


                <tr>

                    <td>
                        <span class="status-pending">
                            Pending
                        </span>
                    </td>

                    <td>
                        <%= request.getAttribute("pendingRequests") %>
                    </td>

                </tr>


                <tr>

                    <td>
                        <span class="status-approved">
                            Approved
                        </span>
                    </td>

                    <td>
                        <%= request.getAttribute("approvedRequests") %>
                    </td>

                </tr>


                <tr>

                    <td>
                        <span class="status-rejected">
                            Rejected
                        </span>
                    </td>

                    <td>
                        <%= request.getAttribute("rejectedRequests") %>
                    </td>

                </tr>

            </table>

        </div>

    </div>

</div>

</body>

</html>