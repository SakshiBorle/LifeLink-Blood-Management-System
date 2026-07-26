<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Admin Login | LifeLink</title>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/style.css">

</head>

<body>

<div class="login-page">

    <div class="login-card">

        <h1 class="logo">LifeLink</h1>

        <h2>Admin Login</h2>

        <p>
            Sign in to manage the LifeLink system.
        </p>

        <form action="LoginServlet" method="post">

            <div class="form-group">

                <label>Username</label>

                <input type="text"
                       name="username"
                       placeholder="Enter username"
                       required>

            </div>

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       placeholder="Enter password"
                       required>

            </div>

            <button type="submit"
                    class="btn btn-primary btn-full">

                Login

            </button>

        </form>

        <br>

        <a href="index.jsp">
            ← Back to role selection
        </a>

    </div>

</div>

</body>

</html>