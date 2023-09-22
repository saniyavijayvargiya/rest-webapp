package rest;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UserDao {

	Connection con;
	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addUser(User user) {
		int count1 = 0;
		int count2 = 0;
		
		try {
			PreparedStatement st1 = con.prepareStatement("insert into login (email, password) values(?, ?);");
			st1.setString(1, user.getEmail());
			st1.setString(2, user.hashPassword(user.getPassword()));
			count1 = st1.executeUpdate();
			
			PreparedStatement st2 = con.prepareStatement("insert into details (fname, lname, address, city, state, zipcode, phone, email) values (?, ?, ?, ?, ?, ?, ?, ?);");
			st2.setString(1, user.getFname());
			st2.setString(2, user.getLname());
			st2.setString(3, user.getAddress());
			st2.setString(4, user.getCity());
			st2.setString(5, user.getState());
			st2.setString(6, user.getZipcode());
			st2.setString(7, user.getPhone());
			st2.setString(8, user.getEmail());
			count2 = st2.executeUpdate();
			System.out.println(count2 + " row(s) affected");
			
			st1.close();
			st2.close();
			con.close();
				
		} catch (Exception exc) {
			System.out.println(exc);
		}
		
		if (count1 == 1 && count2 == 1) {
			return true;
		} else {
			return false; 
		}
	}
}