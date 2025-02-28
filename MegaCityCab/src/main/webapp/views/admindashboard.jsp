<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../css/admindashboard.css">
</head>
<body>
    <h1>Welcome Admin</h1>
    <p>Welcome to the Admin Dashboard</p>
    
    <!-- Admin-specific content -->
    <div>
        <h3>Manage Users</h3>
        <p>Here you can manage user accounts.</p>
        <a href="manageUsers.jsp">Go to User Management</a>
    </div>
    
    <div>
        <h3>System Settings</h3>
        <p>Manage system settings and configurations.</p>
        <a href="systemSettings.jsp">Go to System Settings</a>
    </div>

    <div>
        <a href="/MegaCityCab/LogoutServlet">Logout</a>
    </div>
</body>
</html>