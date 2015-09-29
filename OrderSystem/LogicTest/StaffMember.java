public class StaffMember {
	
	private int staffID;
	private String name;
	private String password;
	
	public StaffMember(int newStaffID, String newName, String newPassword) {
		staffID=newStaffID;
		name=newName;
		password=newPassword;
	}		
	public int getStaffId(){
		return (int) (staffID);
	}
}
