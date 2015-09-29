public class MenuItem {
	
	private int id;
	private String name;
	private float price;
	
	public MenuItem(int newId, String newName, float newPrice){
		id=newId;
		name=newName;
		price=newPrice;
	}
	
	public updatePrice(float updatedPrice){
		price=updatedPrice;
	}
}
