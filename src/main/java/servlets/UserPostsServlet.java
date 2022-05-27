package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import beans.User;

import dao.DBConnection;
import dao.PostDao;

/**
 * Servlet implementation class UserPostsServlet
 */
@WebServlet("/user/posts")
public class UserPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> posts = new ArrayList<Post>();
		try {
			DBConnection connection = new DBConnection();
			PostDao dao = new PostDao(connection);
			posts = dao.getPosts((User)request.getSession().getAttribute("user"));
			connection.close();
		} catch(Exception e) { 
			request.setAttribute("error", e.getMessage()); 
		}
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/view/AdsPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
