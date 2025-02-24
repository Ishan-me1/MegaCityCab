package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            
            
            
         // Validate inputs to ensure no fields are empty
            if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty()) {
                response.sendRedirect("views/register.jsp?error=Please fill in all fields.");
                return;  // Stop further execution if validation fails
            }


            // Call DAO to register user
            UserDAO dao = new UserDAO();
            boolean success = dao.registerUser(username, password, email, phone);
            
            if (success) {
                response.sendRedirect("views/login.jsp?msg=Registration Successful");
            } else {
                response.sendRedirect("views/register.jsp?error=Registration Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("views/register.jsp?error=An error occurred. Please try again.");
        }
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}
