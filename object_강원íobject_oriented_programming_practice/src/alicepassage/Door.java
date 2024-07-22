package alicepassage;

public class Door {
	private boolean flag = false;
	
	public boolean openDoor(){
		this.flag = true;
		return this.flag;
	}
}
