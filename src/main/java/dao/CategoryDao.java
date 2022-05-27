package dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class CategoryDao {
	
	private DBConnection connection;
	
	public CategoryDao(DBConnection connection) {
		this.connection = connection;
	}
	
	public HashMap<String, Set<String>> getCategories() throws SQLException {
		String sql = "select * from sub_categories";
		ResultSet result = connection.executeQuery(sql);
		HashMap<String, Set<String>> categories = new HashMap<String, Set<String>>();
		while(result.next()) {
			String key = result.getString("parent_category");
			Set<String> set = categories.get(key);
			if(set == null) {
				set = new HashSet<String>();
				categories.put(key, set);
			}
			set.add(result.getString("name"));
		}
		return categories;
	}
}
