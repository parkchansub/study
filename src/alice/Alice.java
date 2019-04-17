package alice;

public class Alice {
	private int tall = 130;
	private String status = "home";
	
	public void drunked(){
		this.tall = tall-40;
		
		Drink drink = new Drink();
		drink.downVolume(5);
	}
	
	public void eatCake(){
		
	}
	
	public int getTall(){
		return this.tall;
	}
}
