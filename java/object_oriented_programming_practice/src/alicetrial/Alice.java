package alicetrial;

public class Alice implements Witness{

	@Override
	public void testify() {
		System.out.println("엘리스 증언");
	}

	@Override
	public void entrance() {
		System.out.println("엘리스 재판장에 입장");
	}
	
}
