<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.lifelink.model.Hospital" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect("login.jsp");
    return;
}

List<Hospital> hospitals =
        (List<Hospital>) request.getAttribute("hospitals");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Manage Hospitals | LifeLink</title>

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

            <h1>Manage Hospitals</h1>

            <p>
                View and manage hospitals registered with LifeLink.
            </p>

        </div>


        <a href="addHospital.jsp"
           class="btn btn-primary">

            Add Hospital

        </a>


        <div class="table-card">

            <table>

                <tr>

                    <th>ID</th>
                    <th>Hospital Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Username</th>
                    <th>Action</th>

                </tr>


                <%
                if (hospitals != null
                        && !hospitals.isEmpty()) {

                    for (Hospital hospital : hospitals) {
                %>


                <tr>

                    <td>
                        <%= hospital.getHospitalId() %>
                    </td>


                    <td>

                        <strong>
                            <%= hospital.getHospitalName() %>
                        </strong>

                    </td>


                    <td>
                        <%= hospital.getEmail() %>
                    </td>


                    <td>
                        <%= hospital.getPhone() %>
                    </td>


                    <td>
                        <%= hospital.getAddress() %>
                    </td>


                    <td>
                        <%= hospital.getUsername() %>
                    </td>


                    <td>

                        <a href="EditHospitalServlet?id=<%= hospital.getHospitalId() %>"
                           class="btn">

                            Edit

                        </a>


                        <a href="DeleteHospitalServlet?id=<%= hospital.getHospitalId() %>"
                           class="btn"
                           onclick="return confirm('Are you sure you want to delete this hospital?');">

                            Delete

                        </a>

                    </td>

                </tr>


                <%
                    }

                } else {
                %>


                <tr>

                    <td colspan="7"
                        style="text-align:center;
                               padding:30px;">

                        No hospitals found.

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