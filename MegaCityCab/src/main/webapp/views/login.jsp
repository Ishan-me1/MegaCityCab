<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/login.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2196F3, #64B5F6); /* Blue gradient background */
            color: #000000;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            background: rgba(255, 255, 255, 0.9); /* White semi-transparent container */
            backdrop-filter: blur(10px);
            border-radius: 12px;
            padding: 30px;
            width: 35%;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            border: 2px solid #0288d1;
        }

        h2 {
            color: #0277bd;
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin: 15px 0 5px;
            color: #01579b;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 12px;
            border-radius: 5px;
            border: 2px solid #0288d1;
            background-color: #e3f2fd;
            color: #000000;
            font-size: 16px;
        }

        input:focus {
            outline: none;
            border-color: #0277bd;
            box-shadow: 0 0 8px rgba(2, 119, 189, 0.5);
        }

        button {
            background-color: #0277bd;
            color: white;
            padding: 14px 22px;
            border: none;
            border-radius: 5px;
            margin-top: 20px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            width: 100%;
            transition: background 0.3s;
        }

        button:hover {
            background-color: #01579b;
        }

        button:active {
            background-color: #013a63;
        }

        .error-message {
            text-align: center;
            font-size: 16px;
            color: #d32f2f;
            font-weight: bold;
            margin-top: 10px;
        }

        .register-link {
            display: inline-block;
            text-decoration: none;
            color: #ffffff;
            background-color: #0288d1;
            padding: 12px 18px;
            border-radius: 5px;
            margin-top: 15px;
            font-size: 16px;
            font-weight: bold;
            transition: background 0.3s;
        }

        .register-link:hover {
            background-color: #01579b;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="/MegaCityCab/Loginservlet" method="post">
            <label>Username:</label>
            <input type="text" name="username" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <button type="submit">Login</button>

            <% if (request.getParameter("error") != null) { %>
                <p class="error-message">${param.error}</p>
            <% } %>
        </form>
        <a href="register.jsp" class="register-link">Don't have an account? Register here</a>
    </div>
</body>
</html>
