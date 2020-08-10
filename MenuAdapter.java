package project;

import java.util.Iterator;

class MenuAdapter {
	MenuList menuList;
	
	MenuAdapter(){
		menuList = new SnackBar();
	}
	
	Object[][] getAllMenu(){
		Object[][] result = new Object[getIteratorLength(menuList.getAllMenu())][];
		
		/*======= Iterator Pattern 적용 : 메뉴리스트의 iterator를 반환받아서 모든 메뉴아이템을 순환 =======*/
		Iterator<MenuItem> iterator = menuList.getAllMenu();
		
		for(int i = 0; i < result.length; i++) {
			MenuItem menu = (MenuItem)iterator.next();
			String name = menu.getName();
			String description = menu.getDescription();
			String price = Integer.toString(menu.getPrice());
			result[i] = new Object[]{name, description, price};
		}
		
		return result;
	}
	
	Object[][] getMenu(String type){
		Object[][] result = new Object[getIteratorLength(menuList.getMenu(type))][];
		Iterator<MenuItem> iterator = menuList.getMenu(type);
		
		for(int i = 0; i < result.length; i++) {
			MenuItem menu = (MenuItem)iterator.next();
			String name = menu.getName();
			String description = menu.getDescription();
			String price = Integer.toString(menu.getPrice());
			result[i] = new Object[]{name, description, price};
		}
		
		return result;
	}
	
	Object[][] getAllMenuByPrice(){
		Object[][] result = new Object[getIteratorLength(menuList.getAllMenu())][];
		Iterator<MenuItem> iterator;
		String name, description, price;
		int p = 500;
		
		for(int i = 0; i < result.length; p += 500) {
			iterator = menuList.getAllMenu();
			while(iterator.hasNext()){
				MenuItem menu = (MenuItem)iterator.next();
				if(menu.getPrice() == p) {
					name = menu.getName();
					description = menu.getDescription();
					price = Integer.toString(menu.getPrice());
					result[i] = new Object[]{name, description, price};
					i++;
				}
			}
		}
		
		return result;
	}
	
	// iterator의 길이를 알 수 있는 함수가 없어서 추가
	int getIteratorLength(Iterator iterator) {
		int length = 0;
		
		while(iterator.hasNext()) {
			iterator.next();
			length++;
		}
		
		return length;
	}
}
