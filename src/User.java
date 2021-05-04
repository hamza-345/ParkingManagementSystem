import java.awt.Frame;
import java.util.UUID;

import javax.swing.JOptionPane;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
	
	public User(String firstname, String lastName, String email, String password, String type) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public User() {
	
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	public String getlastName() {
		return this.lastName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 
	
	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [name=" + firstName +" "+ lastName + ", id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	public static String exists(String user, String password) {
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/users.csv";
		MaintainUser maintain = new MaintainUser();
		try {
			maintain.load(path);
			for(User u: maintain.users){
				if(u.getEmail().equals(user) && u.getPassword().equals(password)) {
					return u.getType();
				}
			}
		}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			}
		return "false";

	}
}

