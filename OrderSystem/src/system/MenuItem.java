package system;

public class MenuItem {
	
	private int id;
	private String name;
	private float price;
	
	public MenuItem(String newId, String newName, String newPrice){
		id = Integer.parseInt(newId);
		setName(newName);
		price = Float.parseFloat(newPrice);
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
