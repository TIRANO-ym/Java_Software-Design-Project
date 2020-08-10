package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class WaitingQueue{
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollPane;
	String[] collum;
	
	/*======= Singleton Pattern ����: �ֹ� ��� ����� �����ϰ� �� ���� ����ϵ��� ���� =======*/
	private static WaitingQueue waitingQueue = new WaitingQueue();
	
	private WaitingQueue(){
		setup();
	}
	
	public static WaitingQueue getInstance() {
		return waitingQueue;
	}
	
	void setup() {
		collum = new String[]{"���̺� ��ȣ", "�޴���"};
		model = new DefaultTableModel(null, collum);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
	}
	
	void order(int number, Object name) {
		Object[] data = new Object[] {number, name};
		model.addRow(data);
	}
	
	JScrollPane getScrollPane() {
		return scrollPane;
	}
}

class WaitingDisplayer{
	WaitingQueue queue = WaitingQueue.getInstance();
	JFrame frame;
	Container container;
	JButton close;
	
	WaitingDisplayer(){
		setup();
		prepare();
	}
	
	void setup() {
		frame = new JFrame("��� ���");
		container = frame.getContentPane();
		close = new JButton("�ݱ�");
	}
	
	void prepare() {
		close.addActionListener((ActionEvent e) -> {
			frame.dispose();
		});

		container.setLayout(new BorderLayout());
	}
	
	void build() {
		container.add(queue.getScrollPane(), BorderLayout.NORTH);
		container.add(close, BorderLayout.SOUTH);
		frame.pack();
	}
	
	void display() {
		build();
		frame.setVisible(true);
	}
}
