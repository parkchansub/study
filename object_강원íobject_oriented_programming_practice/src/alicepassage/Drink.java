package alicepassage;

public class Drink implements Eat{
	private int volume = 10;
	
	public void downVolume(int volume){
		this.volume = this.volume - volume;
	}

	@Override
	public int getVolume() {
		return this.volume;
	}
}
