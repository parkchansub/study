package alicetrial;

public class play {

	public static void main(String[] args) {
		King king = new King();
		Rabbit rabbit = new Rabbit();
		Witness alice = new Alice();
		Witness meWitness = new Merchant();
		
		
		king.requestTestify(alice);
		king.requestTestify(meWitness);
		
		rabbit.requestEntrance(alice);
		rabbit.requestEntrance(meWitness);
				
	}

}
