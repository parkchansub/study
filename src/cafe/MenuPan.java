package cafe;

import java.util.List;

public class MenuPan {
	private List<MenuItem> menuList;
	
	public void AddMenuItem(MenuItem menuItem){
		this.menuList.add(menuItem);
	}
}
