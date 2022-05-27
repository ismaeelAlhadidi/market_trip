package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;
import dao.UserDao;

import beans.User;

/**
 * Servlet implementation class UserSettingServlet
 */
@WebServlet("/user/settings")
public class UserSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSettingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/Settings.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection connection = new DBConnection();
			String firstName = request.getParameter("first_name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phone_number");
			if(email == null || email.length() == 0 || firstName == null || firstName.length() == 0) {
				request.setAttribute("error", (email == null || email.length() == 0 ? "email" : "first name") + " is required");
				doGet(request, response);
				return;
			}
			String oldEmail = ((User)request.getSession().getAttribute("user")).getEmail();
			String oldLastName = ((User)request.getSession().getAttribute("user")).getEmail();
			UserDao dao = new UserDao(connection);
			String dataState = dao.validateUserUpdateData(email, firstName, address, phoneNumber, oldEmail);
			if(! dataState.equals("ok")) {
				request.setAttribute("error", dataState);
				doGet(request, response);
				return;
			}
			if(! dao.updateData(email, firstName, address, phoneNumber, oldEmail)) {
				request.setAttribute("error", "there is error, please try again !!");
				doGet(request, response);
				return;
			}
			request.setAttribute("error", "changes saved");
			request.getSession().setAttribute("user", new User(email, firstName, oldLastName, address, phoneNumber));
			connection.close();
		} catch(Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		doGet(request, response);
	}
}
