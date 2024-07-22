package cafe;

import java.util.List;

public class Menu {
	private List<MenuItem> items;
	
	
	//내가 기록한 코드
//	public void AddMenuItem(MenuItem menuItem){
//		this.items.add(menuItem);
//	}
//	
//	public MenuItem choose(String name) {
//		for(int i=0;i<items.size();i++){
//			if(items.get(i).getName().equals(name)){
//				return items.get(i);
//			}
//		}
//		return null;
//	}
	
	// 책 코드
	public Menu(List<MenuItem> items) {
		this.items = items;
	}
	public MenuItem choose(String name) {
		for(MenuItem each : items) {
			if(each.getName().equals(name)) {
				return each;
			}
		}
		return null;
	}
	
}
