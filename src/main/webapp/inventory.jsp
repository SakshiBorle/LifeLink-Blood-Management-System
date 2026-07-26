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

List<BloodInventory> inventoryList =
        (List<BloodInventory>) request.getAttribute("inventoryList");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Blood Inventory | LifeLink</title>

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

            <h1>Blood Inventory</h1>

            <p>
                Monitor and manage available blood stock.
            </p>

        </div>


        <div class="table-card">

            <table>

                <tr>
                    <th>ID</th>
                    <th>Blood Group</th>
                    <th>Available Units</th>
                    <th>Add Stock</th>
                    <th>Remove Stock</th>
                </tr>


                <%
                if (inventoryList != null) {

                    for (BloodInventory inventory : inventoryList) {
                %>


                <tr>

                    <td>
                        <%= inventory.getInventoryId() %>
                    </td>


                    <td>

                        <strong>
                            <%= inventory.getBloodGroup() %>
                        </strong>

                    </td>


                    <td>

                        <%= inventory.getAvailableUnits() %>
                        units

                    </td>


                    <!-- ADD STOCK -->

                    <td>

                        <form action="AddStockServlet"
                              method="post">

                            <input type="hidden"
                                   name="inventoryId"
                                   value="<%= inventory.getInventoryId() %>">

                            <input type="number"
                                   name="units"
                                   min="1"
                                   placeholder="Units"
                                   required
                                   style="padding:10px;
                                          width:90px;
                                          border:1px solid #d1d5db;
                                          border-radius:8px;">

                            <button type="submit"
                                    class="btn btn-primary">

                                Add

                            </button>

                        </form>

                    </td>


                    <!-- REMOVE STOCK -->

                    <td>

                        <form action="RemoveStockServlet"
                              method="post">

                            <input type="hidden"
                                   name="inventoryId"
                                   value="<%= inventory.getInventoryId() %>">

                            <input type="number"
                                   name="units"
                                   min="1"
                                   placeholder="Units"
                                   required
                                   style="padding:10px;
                                          width:90px;
                                          border:1px solid #d1d5db;
                                          border-radius:8px;">

                            <button type="submit"
                                    class="btn">

                                Remove

                            </button>

                        </form>

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