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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/user/change_password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/changePSW.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection connection = new DBConnection();
			UserDao dao = new UserDao(connection);
			String oldPassword = request.getParameter("old_password");
			String newPassword = request.getParameter("new_password");
			if(oldPassword == null || oldPassword.length() == 0) {
				request.setAttribute("error", "please enter the old password !!");
				doGet(request, response);
				return;
			}
			if(newPassword == null || newPassword.length() == 0) {
				request.setAttribute("error", "please enter the new password !!");
				doGet(request, response);
				return;
			}
			if(oldPassword.length() > 255) {
				request.setAttribute("error", "password is incorrect !!");
				doGet(request, response);
				return;
			}
			if(newPassword.length() > 255) {
				request.setAttribute("error", "password must be less than 256 characters !");
				doGet(request, response);
				return;
			}
			String email = ((User)request.getSession().getAttribute("user")).getEmail();
			User user = dao.getUser(email, oldPassword);
			if(user == null) {
				request.setAttribute("error", "password is incorrect !!");
				doGet(request, response);
				return;
			}
			if(! dao.changePassword(email, newPassword)) {
				request.setAttribute("error", "there is error, please try again");
				doGet(request, response);
				return;
			}
		} catch(Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("error", "password changed");
		doGet(request, response);
	}

}
