package cafe;

import java.util.List;

public class Menu {
	private List<MenuItem> menuList;
	
	public void AddMenuItem(MenuItem menuItem){
		this.menuList.add(menuItem);
	}
	
	public MenuItem choose(String name) {
		for(int i=0;i<menuList.size();i++){
			if(menuList.get(i).getName().equals(name)){
				return menuList.get(i);
			}
		}
		return null;
	}
	
	
}
