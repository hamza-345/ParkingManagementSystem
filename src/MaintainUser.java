import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser {
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			user.setId(reader.get("id"));
			user.setfirstName(reader.get("firstName"));
			user.setlastName(reader.get("lastName"));
			user.setEmail(reader.get("emailAddress"));
			user.setPassword(reader.get("password"));
			user.setType(reader.get("type"));
			users.add(user);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("id");
				csvOutput.write("firstName");
		    	csvOutput.write("lastName");
				csvOutput.write("emailAddress");
				csvOutput.write("password");
				csvOutput.write("type");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: this.users){
					csvOutput.write(u.getId());
					csvOutput.write(u.getfirstName());
					csvOutput.write(u.getlastName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getType());
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
