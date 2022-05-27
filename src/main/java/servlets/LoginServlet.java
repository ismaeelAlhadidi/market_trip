package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.DBConnection;
import dao.UserDao;
import helpers.URL;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection connection = new DBConnection();
			UserDao dao = new UserDao(connection);
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if(email == null || email.length() == 0 || password == null || password.length() == 0) {
				request.setAttribute("error", "please enter your " + (email == null || email.length() == 0 ? "email" : "password"));
				doGet(request, response);
				return;
			}
			User user = dao.getUser(email, password);
			if(user == null) {
				request.setAttribute("error", "email or passord incorecct !!");
				doGet(request, response);
				return;
			}
			request.getSession().setAttribute("user", user);
			connection.close();
		} catch(Exception e) {
			request.setAttribute("error", e.getMessage());
			doGet(request, response);
			return;
		}
		response.sendRedirect(URL.getBaseUrl(request));
	}
}
