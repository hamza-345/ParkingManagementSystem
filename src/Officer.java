import java.awt.Frame;

import javax.swing.JOptionPane;

public class Officer extends User {
	Officer(String firstName, String lastName, String emailAddress, String password) {
		super(firstName, lastName, emailAddress, password, "officer");
	}
	public static void addSpace(parkingSpace space) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/parkingSpaces.csv";
		MaintainSpace maintain = new MaintainSpace();
		try {
			maintain.load(path);
			for(parkingSpace u: maintain.spaces){
				if(u.getSpaceNumber().equals(space.getSpaceNumber())) {
					JOptionPane.showMessageDialog(new Frame(), "Space Already Exists!");
					exists = true;
					break;
				}
			}
			if(! exists) {
					maintain.spaces.add(space);
					JOptionPane.showMessageDialog(new Frame(), "Space Added!");
					maintain.update(path);
				}
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
	}
	public static void removeSpace(String spaceNumber) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/parkingSpaces.csv";
		MaintainSpace maintain = new MaintainSpace();
		try {
			maintain.load(path);
			for(parkingSpace u: maintain.spaces){
				if(u.getSpaceNumber().equals(spaceNumber)) {
					maintain.spaces.remove(u);
					maintain.update(path);
					JOptionPane.showMessageDialog(new Frame(), "Space Removed");
					exists = true;
					break;
				}
			}
			if(!exists) {
					JOptionPane.showMessageDialog(new Frame(), "Space doesn't exist!");
					maintain.update(path);
			}
		}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
	}
	public static void grantRequest(String bookingID) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			for(Booking u: maintain.booking){
				if(u.getId().equals(bookingID)) {
						u.setGranted("yes");
						maintain.update(path);
						JOptionPane.showMessageDialog(new Frame(), "Granted Request");
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
	public static void cancelRequest(String bookingID) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			for(Booking u: maintain.booking){
				if(u.getId().equals(bookingID)) {
						maintain.booking.remove(u);
						maintain.update(path);
						JOptionPane.showMessageDialog(new Frame(), "Request removed!");
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
