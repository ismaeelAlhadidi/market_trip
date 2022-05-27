package dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import beans.Post;
import beans.User;

import helpers.URL;

public class PostDao {
	DBConnection connection;
	
	public PostDao(DBConnection connection) throws SQLException {
		
		this.connection = connection;
	}
	public boolean addPost(String content, String image, String subCategories, String price, String contactEmail, String phoneNumber, String email) throws SQLException {
		String sql = "insert into posts (content,image,sub_category,contact_email,contact_phone,email,price) values(";
		sql += ("\"" + content + "\", ");
		sql += ("\"" + image + "\", ");
		sql += ("\"" + subCategories + "\", ");
		sql += ("\"" + contactEmail + "\", ");
		sql += ("\"" + phoneNumber + "\", ");
		sql += ("\"" + email + "\", ");
		sql += ("" + price + "");
		sql += ");";
		if(connection.executeUpdate(sql) != 1) {
			return false;
		}
		return true;
	}
	
	public List<Post> getPosts(User user) throws SQLException {
		String sql = "select * from posts where email=\"" + user.getEmail() + "\" order by created DESC;";
		return fetchPosts(sql);
	}
	
	public List<Post> getPosts(String subCategory) throws SQLException {
		if(subCategory != null) {
			subCategory = URL.fixTheSearchQuery(subCategory);
		}
		String sql = "select * from posts";
		sql += (subCategory != null ? (" where sub_category=\"" + subCategory + "\"") : "");
		sql += " order by created DESC;";
		return fetchPosts(sql);
	}
	
	private List<Post> fetchPosts(String sql) throws SQLException {
		ResultSet result = connection.executeQuery(sql);
		List<Post> posts = new ArrayList<Post>();
		while(result.next()) {
			Post post = new Post();
			post.setContent(result.getString("content"));
			post.setImage(result.getString("image"));
			post.setEmail(result.getString("contact_email"));
			post.setPhoneNumber(result.getString("contact_phone"));
			post.setPrice(result.getString("price"));
			post.setSubCategory(result.getString("sub_category"));
			posts.add(post);
		}
		return posts;
	}
}
