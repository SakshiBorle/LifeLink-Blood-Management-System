<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.lifelink.model.BloodRequest" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}

List<BloodRequest> requestList =
        (List<BloodRequest>) request.getAttribute("requestList");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Blood Requests | LifeLink</title>

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

            <h1>Blood Requests</h1>

            <p>
                Review and manage hospital blood requests.
            </p>

        </div>


        <div class="table-card">

            <table>

                <tr>

                    <th>Request ID</th>

                    <th>Hospital ID</th>

                    <th>Patient</th>

                    <th>Blood Group</th>

                    <th>Units</th>

                    <th>Emergency</th>

                    <th>Reason</th>

                    <th>Date</th>

                    <th>Status</th>

                    <th>Action</th>

                </tr>


                <%
                if (requestList != null) {

                    for (BloodRequest bloodRequest : requestList) {
                %>


                <tr>

                    <td>
                        <%= bloodRequest.getRequestId() %>
                    </td>


                    <td>
                        <%= bloodRequest.getHospitalId() %>
                    </td>


                    <td>
                        <strong>
                            <%= bloodRequest.getPatientName() %>
                        </strong>
                    </td>


                    <td>
                        <strong>
                            <%= bloodRequest.getBloodGroup() %>
                        </strong>
                    </td>


                    <td>
                        <%= bloodRequest.getUnitsRequired() %>
                    </td>


                    <td>
                        <%= bloodRequest.getEmergencyLevel() %>
                    </td>


                    <td>
                        <%= bloodRequest.getReason() %>
                    </td>


                    <td>
                        <%= bloodRequest.getRequestDate() %>
                    </td>


                    <td>

                        <%
                        if ("Pending".equalsIgnoreCase(
                                bloodRequest.getStatus())) {
                        %>

                            <span class="status-pending">
                                Pending
                            </span>

                        <%
                        } else if ("Approved".equalsIgnoreCase(
                                bloodRequest.getStatus())) {
                        %>

                            <span class="status-approved">
                                Approved
                            </span>

                        <%
                        } else {
                        %>

                            <span class="status-rejected">
                                Rejected
                            </span>

                        <%
                        }
                        %>

                    </td>


                    <td>

                        <%
                        if ("Pending".equalsIgnoreCase(
                                bloodRequest.getStatus())) {
                        %>

                            <a href="ApproveRequestServlet?id=<%= bloodRequest.getRequestId() %>"
                               class="btn btn-primary">

                                Approve

                            </a>

                            <a href="RejectRequestServlet?id=<%= bloodRequest.getRequestId() %>"
                               class="btn">

                                Reject

                            </a>

                        <%
                        } else {
                        %>

                            No Action

                        <%
                        }
                        %>

                    </td>

                </tr>


                <%
                    }
                }
                %>


            </table>

        </div>

    </div>

</div>

</body>

</html>