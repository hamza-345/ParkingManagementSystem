
import java.util.UUID;
public class Booking {
	private String id;
	private String spaceNumber;
	private String customerEmailAddress;
	private long timeInMillis;
	private String licensePlate;
	private String granted;
	private String paid;
	
	Booking(String spaceNumber, String customerEmailAddress, long timeInMillis, String licensePlate, String granted, String paid) {
		this.id = UUID.randomUUID().toString();
		this.spaceNumber = spaceNumber;
		this.customerEmailAddress = customerEmailAddress;
		this.timeInMillis = timeInMillis;
		this.licensePlate = licensePlate;
		this.granted = granted;
		this.paid = paid;
	}
	public String getSpaceNumber() {
		return spaceNumber;
	}
	public void setSpaceNumber(String spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	Booking(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}
	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}
	public long getTimeHours() {
		return this.timeInMillis;
	}
	public void setTimeHours(long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", spaceNumber=" + spaceNumber + ", customerEmailAddress=" + customerEmailAddress + ", timeInMillis=" + timeInMillis + ", licensePlate=" + licensePlate + "]";
	}
	public String getGranted() {
		return granted;
	}
	public void setGranted(String granted) {
		this.granted = granted;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
}
