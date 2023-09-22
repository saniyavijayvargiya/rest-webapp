package rest;

import java.security.MessageDigest;
import java.util.Base64;

public class User {
	int id;
	String fname, lname, address, city, state, zipcode, phone, email, password;
	
	public User() {
		super();
	}
	
	public User(String fname, String lname, String address, String city, String state, String zipcode, String phone,
			String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(int id, String fname, String lname, String address, String city, String state, String zipcode,
			String phone, String email, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            return hashedPassword;
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    }
}
