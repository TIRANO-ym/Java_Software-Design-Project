package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

class MenuCommand{
	DefaultTableModel model_menu;
	JButton button;
	
	MenuCommand(DefaultTableModel model_menu, JButton button){
		this.model_menu = model_menu;
		this.button = button;
	}
	
	protected void removeAllMenuList() {
		int count = model_menu.getRowCount();
		for(int i = 0; i < count; i++)		// 현재 메뉴목록 모두 지우기
			model_menu.removeRow(0);
		button.setEnabled(false);
	}
}

class SortByLowCommand extends MenuCommand implements ActionListener{
	Object[][] data;
	
	SortByLowCommand(OrderSystem s){
		super(s.model_menu, s.add);
		data = s.menuAdapter.getAllMenuByPrice();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		removeAllMenuList();
		for(int i = 0; i < data.length; i++)
			model_menu.addRow(data[i]);
	}
}

class SortByHighCommand extends MenuCommand implements ActionListener{
	Object[][] data;
	
	SortByHighCommand(OrderSystem s){
		super(s.model_menu, s.add);
		data = s.menuAdapter.getAllMenuByPrice();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		removeAllMenuList();
		for(int i = data.length-1; i >= 0; i--)
			model_menu.addRow(data[i]);
	}
}

class FilterCommand extends MenuCommand implements ActionListener{
	Object[][] data;
	
	FilterCommand(OrderSystem s, String type){
		super(s.model_menu, s.add);
		data = s.menuAdapter.getMenu(type);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		removeAllMenuList();
		for(int i = 0; i < data.length; i++)
			model_menu.addRow(data[i]);
	}
}

class FilterAllCommand extends MenuCommand implements ActionListener{
	Object[][] data;
	
	FilterAllCommand(OrderSystem s){
		super(s.model_menu, s.add);
		data = s.menuAdapter.getAllMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		removeAllMenuList();
		for(int i = 0; i < data.length; i++) 
			model_menu.addRow(data[i]);
	}
}