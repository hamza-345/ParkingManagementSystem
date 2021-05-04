import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Customer extends User {
	Customer(String firstName, String lastName, String emailAddress, String password) {
		super(firstName, lastName, emailAddress, password, "customer");
	}
	public static void bookSpace(Booking book) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			for(Booking u: maintain.booking){
				if(u.getSpaceNumber().equals(book.getSpaceNumber())) {
					if(u.getTimeHours() > book.getTimeHours())
						JOptionPane.showMessageDialog(new Frame(), "Space is already occupied!");
						exists = true;
						break;
				}
			}
			if(! exists) {
					maintain.booking.add(book);
					JOptionPane.showMessageDialog(new Frame(), "Booking Added!");
					maintain.update(path);
				}
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public static void cancelSpace(String bookingID) {
		Boolean exists = false;
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			for(Booking u: maintain.booking){
				if(u.getId().equals(bookingID)) {
					maintain.booking.remove(u);
					JOptionPane.showMessageDialog(new Frame(), "Booking Removed");
					exists = true;
					break;
				}
			}
			if(!exists) {
					JOptionPane.showMessageDialog(new Frame(), "Booking doesn't exist!");
				}
			maintain.update(path);
			}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	public static void viewBooking() {
		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/src/CSV Files/Booking.csv";
		MaintainBooking maintain = new MaintainBooking();
		try {
			maintain.load(path);
			JFrame f = new JFrame("Test");
	        f.add(new JList(maintain.booking.toArray()));
	        f.setTitle("MainGUI");
	        f.setVisible(true);
	        f.setBounds(10, 10, 370, 600);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setResizable(false);
	}
		catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
		
}
