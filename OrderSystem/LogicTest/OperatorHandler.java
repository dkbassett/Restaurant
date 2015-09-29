public class OperatorHandler {
	
	private StaffMember currentOperator;
	
	public  OperatorHandler (StaffMember newStaffMember) { //initialises operation handler with given StaffMember instance
		currentOperator=newStaffMember;	
	}
	
	public int getOperator(){ // returns currentOperator ID
		return (int) (currentOperator.staffID);
	}
	
	public StaffMember updateCurrentOperator(StaffMember newStaffMember) { //updates currentOperator to given StaffMember
		currentOperator=newStaffMember;
	}
}
