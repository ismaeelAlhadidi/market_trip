package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.DBConnection;
import dao.PostDao;

import java.util.HashMap;
import java.util.Set;

import beans.User;
import beans.Post;

import com.google.gson.Gson;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/user/post")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("categories") == null) {
			try {
				DBConnection connection = new DBConnection();
				CategoryDao dao = new CategoryDao(connection);
				HashMap<String, Set<String>> categories = dao.getCategories();
				if(categories == null) {
					request.setAttribute("error", "there is problem with database !!");
				} else {
					request.getSession().setAttribute("categories", categories);
				}
			} catch(Exception e) { 
				request.setAttribute("error", e.getMessage());
			}
		}
		request.getRequestDispatcher("/view/Post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "the post inserted";
		try {
			DBConnection connection = new DBConnection();
			PostDao dao = new PostDao(connection);
			Post post = new Gson().fromJson(request.getReader(), Post.class);
			if(! dao.addPost(
					post.content, 
					post.image,
					post.subCategory, 
					post.price,
					post.email, 
					post.phoneNumber, 
					((User)request.getSession().getAttribute("user")).getEmail())) {
				
				msg = "there is an error, please try agin";
			}
			connection.close();
		} catch(Exception e) {
			msg = e.getMessage();
		}
		String jsonString = "{\"msg\":\"" + msg + "\"}";
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonString);
		out.flush();
	}
}
