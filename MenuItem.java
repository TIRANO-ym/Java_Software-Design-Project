package project;

import java.util.ArrayList;

class MenuItem {
	String name, description;
	int price;
	
	MenuItem(String name, String description, int price){
		this.name = name;
		this.description = description;
		this.price = price;
	}
	String getName() {
		return name;
	}
	String getDescription() {
		return description;
	}
	int getPrice() {
		return price;
	}
}

class Menu{
	String type;
	ArrayList<MenuItem> menuItems = new ArrayList<>();
	
	void addItem(String name, String description, int price) {
		MenuItem menuItem = new MenuItem(name, description, price);
		menuItems.add(menuItem);
	}
	
	public ArrayList<MenuItem> getMenu(){
		return menuItems;
	}
	
	public String getType() {
		return type;
	}
}

class CasualMenu extends Menu{
	CasualMenu(){
		type = "ºĞ½Ä·ù";
		addItem("±è¹ä", "µ¹µ¹µ¹ ±è¹ä", 2500);
		addItem("¹Ğ¶±ººÀÌ", "Æ¯Á¦¼Ò½º + ¹Ğ¶±", 3000);
		addItem("½Ò¶±ººÀÌ", "Æ¯Á¦¼Ò½º + ½Ò¶±", 3000);
		addItem("¼ø´ë", "ÂÌ±êÇÑ ¼ø´ë ÇÑ ÆÑ", 4000);
	}
}

class MealMenu extends Menu{
	MealMenu(){
		type = "½Ä»ç·ù";
		addItem("ÂüÄ¡¸¶¿äÄÅ¹ä", "ÂüÄ¡+¸¶¿ä³×Áî ÄÅ¹ä", 3000);
		addItem("ÀÜÄ¡±¹¼ö", "È£·Î·Ï ÀÜÄ¡±¹¼ö", 5000);
		addItem("¿À¹Ç¶óÀÌ½º", "Æò¹üÇÑ ¿À¹Ç¶óÀÌ½º", 6000);
		addItem("¿Õµ·±î½º", "¿¾³¯½Ä ¿Õµ·±î½º", 6000);
	}
}

class FriedMenu extends Menu{
	FriedMenu(){
		type = "Æ¢±è·ù";
		addItem("±è¸»ÀÌÆ¢±è", "±è¸»ÀÌÆ¢±è 4°³", 2000);
		addItem("¿ÀÂ¡¾îÆ¢±è", "¿ÀÂ¡¾îÆ¢±è 6°³", 2000);
		addItem("°í±¸¸¶Æ¢±è", "°í±¸¸¶Æ¢±è 6°³", 2000);
		addItem("»õ¿ìÆ¢±è", "»õ¿ìÆ¢±è 4°³", 2000);
		addItem("¸ğµëÆ¢±è", "¹Ù»èÇÑ 4Á¾·ù Æ¢±è Á¾ÇÕ", 7000);
	}
}

class Beverage extends Menu{
	Beverage(){
		type = "À½·á";
		addItem("Äİ¶ó", "ÄÚÄ«Äİ¶ó 500ml", 1000);
		addItem("»çÀÌ´Ù", "Ä¥¼º»çÀÌ´Ù 500ml", 1000);
		addItem("ÄğÇÇ½º", "º¹¼ş¾ÆÄğÇÇ½º 1000ml", 1500);
	}
}