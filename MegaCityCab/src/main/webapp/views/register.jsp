<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
   <link rel="stylesheet" href="../css/register.css"> <!-- Link to external CSS -->
</head>
<body>
    <div class="registration-container">
        <h2>User Registration</h2>

        <form action="/MegaCityCab/RegisterServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" required>

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <label for="phone">Phone:</label>
            <input type="text" name="phone" id="phone" required>

            <label for="name">Full Name:</label>
            <input type="text" name="name" id="name" required>

            <label for="address">Address:</label>
            <textarea name="address" id="address" required></textarea>

            <label for="nic">NIC Number:</label>
            <input type="text" name="nic" id="nic" required>

            <button type="submit">Register</button>
        </form>

        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>
