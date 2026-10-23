<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.lifelink.model.Hospital" %>

<%
Hospital hospital =
        (Hospital) session.getAttribute("hospital");

if (hospital == null) {
    response.sendRedirect("hospitalLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Create Blood Request | LifeLink</title>

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

            <h1>Create Blood Request</h1>

            <p>
                Submit a blood requirement for
                <strong>
                    <%= hospital.getHospitalName() %>
                </strong>
            </p>

        </div>


        <div class="table-card"
             style="max-width:700px;">

            <form action="CreateBloodRequestServlet"
                  method="post">


                <div class="form-group">

                    <label>Patient Name</label>

                    <input type="text"
                           name="patientName"
                           placeholder="Enter patient name"
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

                    <label>Units Required</label>

                    <input type="number"
                           name="unitsRequired"
                           min="1"
                           placeholder="Enter required units"
                           required>

                </div>


                <div class="form-group">

                    <label>Emergency Level</label>

                    <select name="emergencyLevel"
                            required>

                        <option value="">
                            Select emergency level
                        </option>

                        <option value="Low">Low</option>

                        <option value="Medium">
                            Medium
                        </option>

                        <option value="High">High</option>

                        <option value="Critical">
                            Critical
                        </option>

                    </select>

                </div>


                <div class="form-group">

                    <label>Reason</label>

                    <textarea name="reason"
                              rows="5"
                              placeholder="Enter reason for blood requirement"
                              required></textarea>

                </div>


                <button type="submit"
                        class="btn btn-primary">

                    Submit Blood Request

                </button>

            </form>

        </div>

    </div>

</div>

</body>

</html>