<%@ page language="java" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>LifeLink | Blood Management System</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="landing-page">

    <div class="landing-card">

        <h1 class="logo">LifeLink</h1>

        <p class="subtitle">
            Blood Donation & Inventory Management System
        </p>

        <h2>Select Your Role</h2>

        <br>

        <div class="role-container">

            <a href="login.jsp"
               class="role-card">

                <div class="role-icon">
                    A
                </div>

                <h3>Admin</h3>

                <p>
                    Manage hospitals, donors,
                    inventory and blood requests.
                </p>

            </a>


            <a href="hospitalLogin.jsp"
               class="role-card">

                <div class="role-icon">
                    H
                </div>

                <h3>Hospital</h3>

                <p>
                    Request blood and track
                    request status.
                </p>

            </a>

        </div>

    </div>

</div>

</body>

</html>