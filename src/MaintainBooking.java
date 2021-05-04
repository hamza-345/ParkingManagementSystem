import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainBooking {
	public ArrayList<Booking> booking = new ArrayList<>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Booking book = new Booking();
			book.setId(reader.get("id"));
			book.setSpaceNumber(reader.get("spaceNumber"));
			book.setCustomerEmailAddress(reader.get("customerEmailAddress"));
			book.setTimeHours(Long.parseLong(reader.get("timeHours")));
			book.setLicensePlate(reader.get("licensePlate"));
			book.setGranted(reader.get("granted"));
			book.setPaid(reader.get("paid"));
			booking.add(book);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("id");
				csvOutput.write("spaceNumber");
				csvOutput.write("customerEmailAddress");
				csvOutput.write("timeHours");
				csvOutput.write("licensePlate");
				csvOutput.write("granted");
				csvOutput.write("paid");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Booking u: booking){
					csvOutput.write(u.getId());
					csvOutput.write(u.getSpaceNumber());
					csvOutput.write(u.getCustomerEmailAddress());
					csvOutput.write(String.valueOf(u.getTimeHours()));
					csvOutput.write(u.getLicensePlate());
					csvOutput.write(u.getGranted());
					csvOutput.write(u.getPaid());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
//	public static void main(String [] args) throws Exception{
//		String path = "/Users/hamza/eclipse-workspace/ParkingManagementSpace/customers.csv";
//		MaintainUser maintain = new MaintainUser();
//	
//		maintain.load(path);
//		for(User u: maintain.users){
//			System.out.println(u.toString());
//		}
//		
//		User newUser = new User("Hamza", "Hassan" , "t4@yorku.ca", "t4t4");
//		maintain.users.add(newUser);
//		
//		maintain.update(path);
//	}
}
