package rest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


@WebServlet("/signup")
public class SignServlet extends HttpServlet {
	
	public void doOptions(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException {
	    resp.setHeader("Access-Control-Allow-Origin", "*");
	    resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
	    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    resp.setHeader("Access-Control-Max-Age", "7200");
	    resp.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		response.getWriter().write("you can only use post method in this form");
		System.out.println("you can only use post method in this form");
	}
	
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		response.getWriter().write("you can only use post method in this form");
		System.out.println("you can only use post method in this form");
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		response.getWriter().write("you can only use post method in this form");
		System.out.println("you can only use post method in this form");
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		response.getWriter().write("you can only use post method in this form");
		System.out.println("you can only use post method in this form");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		
		JsonReader reader = Json.createReader(request.getReader());
    	JsonObject json = reader.readObject();
    	
    	String fname = json.getString("fname");
    	String lname = json.getString("lname");
    	String address = json.getString("address");
    	String city = json.getString("city");
    	String state = json.getString("state");
    	String zipcode = json.getString("zipcode");
    	String phone = json.getString("phone");
    	String email = json.getString("email");
    	String password = json.getString("password");
    	
    	Connection con = DBConnect.getCon();
		try {
			PreparedStatement st = con.prepareStatement("select * from details where email=?;");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				response.getWriter().write("user already exists");
				System.out.println("user already exists");
			} 
			else {
				User user = new User(fname, lname, address, city, state, zipcode, phone, email, password);
				UserDao dao = new UserDao(DBConnect.getCon());
				boolean f = dao.addUser(user);
				
				if (f == true) {
					response.setStatus(HttpServletResponse.SC_OK);
					response.getWriter().write("successfully signed up");
					System.out.println("successfully signed up");
				} 
			}
		} 
		catch (Exception exc) {
			System.out.println(exc);
		}
	}
}