<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login</title>
<link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <form action="Loginservlet" method="post">
        <h2>Login</h2>
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <button type="submit">Login</button>
              
    </form>
    <a href="register.jsp">Already have an account? Login here</a>
</body>
</html>
