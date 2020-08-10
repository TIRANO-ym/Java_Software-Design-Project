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
		type = "�нķ�";
		addItem("���", "������ ���", 2500);
		addItem("�ж�����", "Ư���ҽ� + �ж�", 3000);
		addItem("�Ҷ�����", "Ư���ҽ� + �Ҷ�", 3000);
		addItem("����", "�̱��� ���� �� ��", 4000);
	}
}

class MealMenu extends Menu{
	MealMenu(){
		type = "�Ļ��";
		addItem("��ġ�����Ź�", "��ġ+������� �Ź�", 3000);
		addItem("��ġ����", "ȣ�η� ��ġ����", 5000);
		addItem("���Ƕ��̽�", "����� ���Ƕ��̽�", 6000);
		addItem("�յ��", "������ �յ��", 6000);
	}
}

class FriedMenu extends Menu{
	FriedMenu(){
		type = "Ƣ���";
		addItem("�踻��Ƣ��", "�踻��Ƣ�� 4��", 2000);
		addItem("��¡��Ƣ��", "��¡��Ƣ�� 6��", 2000);
		addItem("����Ƣ��", "����Ƣ�� 6��", 2000);
		addItem("����Ƣ��", "����Ƣ�� 4��", 2000);
		addItem("���Ƣ��", "�ٻ��� 4���� Ƣ�� ����", 7000);
	}
}

class Beverage extends Menu{
	Beverage(){
		type = "����";
		addItem("�ݶ�", "��ī�ݶ� 500ml", 1000);
		addItem("���̴�", "ĥ�����̴� 500ml", 1000);
		addItem("���ǽ�", "���������ǽ� 1000ml", 1500);
	}
}