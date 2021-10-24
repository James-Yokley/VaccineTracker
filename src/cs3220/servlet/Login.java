package cs3220.servlet;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login</title></head></body>");
		out.println("<form method='POST'>");
		out.println("<label for='username'>Username:</label> <input type='text' id='username' name='username'><br><br>");
		out.println("<label for='password'>Password:</label> <input type='password' id='password' name='password' required>");
		out.println("<br><br><input type='submit' value='Login'></form></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username"); 
		String password = (String) request.getParameter("password"); 
		if(username.equals("cysun") && password.equals("abcd")) {
			request.getSession().setAttribute("User", username);
			response.sendRedirect("Members");
			return; 
		}
		response.sendRedirect("Login");
	}

}
