package system;

public class MenuItem {
	
	private int id;
	private String name;
	private float price;
	
	public MenuItem(int newId, String newName, float newPrice){
		setId(newId);
		setName(newName);
		setPrice(newPrice);
	}
	
	public void updatePrice(float updatedPrice){
		setPrice(updatedPrice);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
