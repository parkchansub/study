package alicetrial;

public class Merchant implements Witness{

	@Override
	public void testify() {
		System.out.println("상인 증언");
	}

	@Override
	public void entrance() {
		System.out.println("상인 재판장에 입장");
		
	}

}
