
public class parkingSpace {
	private String spaceNumber;
	private String occupied;
	parkingSpace(String spaceNumber, String occupied) {
		this.spaceNumber = spaceNumber;
		this.occupied = occupied;
		}
	parkingSpace() {
		
	}
	public String getSpaceNumber() {
		return this.spaceNumber;
	}
	public void setSpaceNumber(String spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public String getOccupied() {
		return this.occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	
	}
