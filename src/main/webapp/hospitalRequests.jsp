<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.lifelink.model.BloodRequest" %>
<%@ page import="com.lifelink.model.Hospital" %>

<%
Hospital hospital =
        (Hospital) session.getAttribute("hospital");

if (hospital == null) {
    response.sendRedirect("hospitalLogin.jsp");
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

<title>My Blood Requests | LifeLink</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="dashboard">

    <!-- SIDEBAR -->

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


    <!-- MAIN CONTENT -->

    <div class="main-content">

        <div class="page-title">

            <h1>My Blood Requests</h1>

            <p>
                View and track requests submitted by
                <strong>
                    <%= hospital.getHospitalName() %>
                </strong>
            </p>

        </div>


        <div class="table-card">

            <table>

                <tr>

                    <th>Request ID</th>

                    <th>Patient</th>

                    <th>Blood Group</th>

                    <th>Units</th>

                    <th>Emergency</th>

                    <th>Reason</th>

                    <th>Date</th>

                    <th>Status</th>

                </tr>


                <%
                if (requestList != null
                        && !requestList.isEmpty()) {

                    for (BloodRequest bloodRequest : requestList) {
                %>


                <tr>

                    <td>
                        <%= bloodRequest.getRequestId() %>
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

                </tr>


                <%
                    }

                } else {
                %>


                <tr>

                    <td colspan="8"
                        style="text-align:center;
                               padding:30px;">

                        No blood requests found.

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