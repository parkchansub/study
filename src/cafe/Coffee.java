package cafe;

public class Coffee {
	private String name;
	private String price;
	
	Coffee(MenuItem menuItem){
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
	}
}
