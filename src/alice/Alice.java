package alice;

public class Alice {
	private int tall = 130;
	private String status = "home";
	
	public void drunked(){
		this.tall = tall-100;
		Drink drink = new Drink();
		drink.downVolume(5);
	}
	
	public void eatCake(){
		
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public int getTall(){
		return this.tall;
	}
	
	public void changeStatus(int tall){
		if(tall<=30){
			this.status = "park";
		}
	}
}
