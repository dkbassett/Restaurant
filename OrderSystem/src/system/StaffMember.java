package system;

public class StaffMember {
	
	private int staffID;
	private String name;
	private String password;
	
	public StaffMember(String newStaffID, String newName, String newPassword) {
		System.out.println("StaffMember-Logic");
		staffID=Integer.parseInt(newStaffID);
		name=newName;
		password=newPassword;
		
		System.out.println("Logic Level: " + staffID);
		System.out.println("Logic Level: " + name);
		System.out.println("Logic Level: " + password);
		
	}		
	public int getStaffId(){
		return (int) (staffID);
	}
}
