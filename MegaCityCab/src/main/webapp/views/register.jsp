<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
<link rel="stylesheet" href="../css/styles.css">

</head>
<body>
    <form action="/MegaCityCab/registerServlet" method="post">
        <h2>Register</h2>
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <label>Email:</label>
        <input type="email" name="email" required>
        
        <label>Phone:</label>
        <input type="text" name="phone" required>
        
        <button type="submit">Register</button>
        
    </form>
    <a href="login.jsp">Already have an account? Login here</a>
</body>
</html>
