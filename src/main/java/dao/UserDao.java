package dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import beans.User;

public class UserDao {
	
	DBConnection connection;
	
	public UserDao(DBConnection connection) throws SQLException {
		
		this.connection = connection;
	}
	
	public String validateUserUpdateData(String email, String firstName, String address, String phoneNumber, String oldEmail) {
		String overflowMsg = "must be less than 256 characters !";
		String emptyMsg = "is required !";
		if(email.length() > 255 || email.length() < 1) {
			return "email " + (email.length() > 255 ? overflowMsg : emptyMsg);
		}
		if(firstName.length() > 255 || firstName.length() < 1) {
			return "first name" + (firstName.length() > 255 ? overflowMsg : emptyMsg);
		}
		if(address.length() > 255) {
			return "first name" + overflowMsg;
		}
		if(phoneNumber.length() != 0) {
			if(phoneNumber.length() != 10) {
				return "phone number must be 10 digits !";
			}
			for(char digit : phoneNumber.toCharArray()) {
				if(digit < '0' || digit > '9') {
					return "phone number must contains only digits !";
				}
			}
		}
		if(email.equals(oldEmail)) {
			return "ok";
		}
		return validateEmail(email);
	}
	
	public String validateEmail(String email) {
		try {
			String sql = "select * from users where email=\"" + email + "\";";
			List<String> parameters = new ArrayList<String>();
			parameters.add(email);
			ResultSet result = connection.executeQuery(sql);
			if(result.next()) {
				return "we have user of entered email, if this your email and you don't have account in our platform yet, please contact us";
			}
		} catch(SQLException e) {
			return e.getMessage();
		}
		return "ok";
	}
	
	public String validateUserRegisterData(String email, String firstName, String lastName, String passowrd) {
		String overflowMsg = "must be less than 256 characters !";
		String emptyMsg = "is required !";
		if(email.length() > 255 || email.length() < 1) {
			return "email " + (email.length() > 255 ? overflowMsg : emptyMsg);
		}
		if(firstName.length() > 255 || firstName.length() < 1) {
			return "first name" + (firstName.length() > 255 ? overflowMsg : emptyMsg);
		}
		if(lastName.length() > 255 || lastName.length() < 1) {
			return "last name " + (lastName.length() > 255 ? overflowMsg : emptyMsg);
		}
		if(passowrd.length() > 255 || passowrd.length() < 1) {
			return "passoword" + (passowrd.length() > 255 ? overflowMsg : emptyMsg);
		}
		return validateEmail(email);
	}
	
	public User createUser(String email, String firstName, String lastName, String password) throws SQLException {
		String sql = "insert into users (email,first_name,last_name,password) values(";
		sql += ("\"" + email + "\",");
		sql += ("\"" + firstName + "\",");
		sql += ("\"" + lastName + "\",");
		sql += ("\"" + password + "\"");
		sql += ")";
		if(connection.executeUpdate(sql) != 1) {
			return null;
		}
		return new User(email, firstName, lastName);
	}
	
	public boolean updateData(String email, String firstName, String address, String phoneNumber, String oldEmail) throws SQLException {
		String sql = "update users set ";
		sql += ("email=\"" + email + "\", ");
		sql += ("first_name=\"" + firstName + "\", ");
		sql += ("address=\"" + address + "\", ");
		sql += ("phone_number=\"" + phoneNumber + "\" ");
		sql += "where email=\"" + oldEmail + "\"";
		if(connection.executeUpdate(sql) != 1) {
			return false;
		}
		return true;
	}
	
	public boolean changePassword(String email, String newPassword) throws SQLException {
		String sql = "update users set password=\"" + newPassword + "\" where email =\"" + email + "\";";
		if(connection.executeUpdate(sql) != 1) {
			return false;
		}
		return true;
	}
	
	public User getUser(String email, String password) throws SQLException {
		ResultSet result = connection.executeQuery("select * from users where email=\"" + email + "\" and password=\"" + password + "\";");
		if(! result.next()) {
			return null;
		}
		return new User(result.getString("email"), result.getString("first_name"), result.getString("last_name"), result.getString("address"), result.getString("phone_number"));
	}
}