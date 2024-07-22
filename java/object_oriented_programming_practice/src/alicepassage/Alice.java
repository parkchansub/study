package alicepassage;

public class Alice {
	private int tall = 130;
	private String status = "home";
	
	public void drunked(Drink drink){
		this.tall = tall-100;
		drink.downVolume(5);
	}
	
	public void eatCake(Cake cake){
		this.tall = tall+50;
		cake.downVolume(5);
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
