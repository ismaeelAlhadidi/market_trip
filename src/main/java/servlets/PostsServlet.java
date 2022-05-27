package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;

import java.util.List;
import java.util.ArrayList;

import dao.DBConnection;
import dao.PostDao;

/**
 * Servlet implementation class PostsServlet
 */
@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsServlet() {
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
			posts = dao.getPosts(request.getParameter("sub_category"));
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
