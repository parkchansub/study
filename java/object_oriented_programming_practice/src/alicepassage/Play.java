package alicepassage;

public class Play {

	public static void main(String[] args) {
		Alice alice = new Alice();
		Drink drink = new Drink();
		Cake cake = new Cake();
		Door door = new Door();
		
		alice.drunked(drink);
		alice.changeStatus(alice.getTall());
		alice.eatCake(cake);
		
		System.out.println(alice.getStatus());
		System.out.println(drink.getVolume());
		System.out.println(cake.getVolume());
		
	}

}
