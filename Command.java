package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class AddCommand implements ActionListener{
	DefaultTableModel model_select;
	JTable table_menu;
	JButton order;

	AddCommand(OrderSystem s){
		model_select = s.model_select;
		table_menu = s.table_menu;
		order = s.order;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = table_menu.getSelectedRow();
		Object[] data = new Object[] {table_menu.getValueAt(index, 0),
									table_menu.getValueAt(index, 2)};
		model_select.addRow(data);		// 주문표에 선택한 메뉴 추가
		order.setEnabled(true);			// [주문하기]버튼 활성화
	}
}

class DeleteCommand implements ActionListener{
	DefaultTableModel model_select;
	JTable table_select;
	JButton delete, order;
	
	DeleteCommand(OrderSystem s){
		model_select = s.model_select;
		table_select = s.table_select;
		delete = s.delete;
		order = s.order;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = table_select.getSelectedRow();
		model_select.removeRow(index);
		
		delete.setEnabled(false);			// 삭제 후 [삭제]버튼 비활성화
		if(model_select.getRowCount() == 0) // 삭제 후 주문표가 비었으면 [주문하기] 비활성화
			order.setEnabled(false);
	}
}

class OrderCommand implements ActionListener{
	DefaultTableModel model_select;
	JButton order;
	int number;
	WaitingQueue waitingQueue = WaitingQueue.getInstance();
	
	OrderCommand(OrderSystem s){
		model_select = s.model_select;
		order = s.order;
		number = s.TABLE_NUMBER;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int count = model_select.getRowCount();
		for(int i = 0; i < count; i++) {
			waitingQueue.order(number, model_select.getValueAt(0, 0));
			model_select.removeRow(0);
		}
		order.setEnabled(false);
	}
}

class WaitingCommand implements ActionListener{
	WaitingDisplayer waitingDisplayer;
	
	WaitingCommand() {
		waitingDisplayer = new WaitingDisplayer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		waitingDisplayer.display();		// 대기 목록 창 띄우기
	}
}