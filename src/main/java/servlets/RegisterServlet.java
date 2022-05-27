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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("view/Signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection connection = new DBConnection();
			String email = request.getParameter("email");
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String password = request.getParameter("password");
			String rPassword = request.getParameter("repeated_password");
			if(email == null || firstName == null || lastName == null || password == null || rPassword == null) {
				request.setAttribute("error", "input all required data !!");
				doGet(request, response);
				return;
			}
			if(! password.equals(rPassword)) {
				request.setAttribute("error", "your entered passowrds not equals !!");
				doGet(request, response);
				return;
			}
			UserDao dao = new UserDao(connection);
			String dataState = dao.validateUserRegisterData(email, firstName, lastName, password);
			if(! dataState.equals("ok")) {
				request.setAttribute("error", dataState);
				doGet(request, response);
				return;
			}
			User user = dao.createUser(email, firstName, lastName, password);
			if(user == null) {
				request.setAttribute("error", "there is unknown error, register failed, please try agin");
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
