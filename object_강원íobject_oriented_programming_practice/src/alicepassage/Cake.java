package alicepassage;

public class Cake implements Eat{
	private int volume;
	
	public void downVolume(int volume){
		this.volume = this.volume - volume;
	}

	@Override
	public int getVolume() {
		return this.volume;
	}
}
