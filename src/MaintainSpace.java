import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainSpace {
	public ArrayList<parkingSpace> spaces = new ArrayList<>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			parkingSpace space = new parkingSpace();
			space.setSpaceNumber(reader.get("spaceNumber"));
			space.setOccupied(reader.get("occupied"));
			spaces.add(space);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("spaceNumber");
				csvOutput.write("occupied");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(parkingSpace u: spaces){
					csvOutput.write(u.getSpaceNumber());
					csvOutput.write(u.getOccupied());
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
