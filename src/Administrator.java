import java.awt.Frame;

import javax.swing.JOptionPane;

public class Administrator extends User {
	Administrator(String firstName, String lastName, String emailAddress, String password) {
		super(firstName, lastName, emailAddress, password, "admin");
	}
	static void addOfficers(Officer officer) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/users.csv";
		MaintainUser maintain = new MaintainUser();
		System.out.println(officer.getEmail());
		try {
			maintain.load(path);
			for(User u: maintain.users){
				System.out.println(u.getEmail());
				if(u.getEmail().equals(officer.getEmail())) {
					JOptionPane.showMessageDialog(new Frame(), "User Already Exists!");
					exists = true;
					break;
				}
			}
			if(! exists) {
					maintain.users.add(officer);
					JOptionPane.showMessageDialog(new Frame(), "User Added!");
					maintain.update(path);
				}
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	}
	public static void removeOfficer(String emailAddress) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/users.csv";
		MaintainUser maintain = new MaintainUser();
		try {
			maintain.load(path);
			for(User u: maintain.users){
				if(u.getEmail().equals(emailAddress)) {
					maintain.users.remove(u);
					System.out.println(maintain.users);
					JOptionPane.showMessageDialog(new Frame(), "Officer Removed");
					
					exists = true;
					break;
				}
			}
			if(!exists) {
					JOptionPane.showMessageDialog(new Frame(), "Officer doesn't exist!");
				}
			maintain.update(path);
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		
		}
	}
	public static void changeStatus(String bookingID) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			for(Booking u: maintain.booking){
				if(u.getId().equals(bookingID)) {
						u.setPaid("yes");
						maintain.update(path);
						JOptionPane.showMessageDialog(new Frame(), "Status Changed");
						exists = true;
						break;
				}
			}
			if(! exists) {
					JOptionPane.showMessageDialog(new Frame(), "ID doesn't exist!");
					maintain.update(path);
				}
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
