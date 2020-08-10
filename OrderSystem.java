package project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class OrderSystem{
	int TABLE_NUMBER;
	
	DefaultTableModel model_menu, model_select;
	JTable table_menu, table_select;
	JScrollPane scroll_menu, scroll_select;
	JFrame frame;
	Container container;
	JButton add, delete, order;
	
	JMenuBar menuBar;
	JMenu menu_sort, menu_filter, menu_waiting;
	JMenuItem mi_all, mi_low, mi_high, mi_casual, mi_meal, mi_fried, mi_beverage, mi_waiting;
	
	MenuAdapter menuAdapter;
	String[] collum_menus, collum_select;
	Object[][] menus;
	
	OrderSystem(int number){
		TABLE_NUMBER = number;
		frame = new JFrame("���� �ֹ� �ý��� - " + TABLE_NUMBER + "�� ���̺�");
	}

	void run() {
		setup();
		prepare();
		build();
		display();
	}
	
	void setup() {
		container = frame.getContentPane();
		
		collum_menus = new String[]{"�޴���", "�޴�����", "����"};
		collum_select = new String[]{"�޴���", "����"};
		
		/*======= Adapter Pattern ���� : ArrayList�� ������ �޴� ����Ʈ�� 2���� �迭�� =======*/
		menuAdapter = new MenuAdapter();
		menus = menuAdapter.getAllMenu();
		
		model_menu = new DefaultTableModel(menus, collum_menus);
		model_select = new DefaultTableModel(null, collum_select);
		
		table_menu = new JTable(model_menu);
		table_select = new JTable(model_select);
		
		scroll_menu = new JScrollPane(table_menu);			// �� ScrollPane�� ���̺� ���
		scroll_select = new JScrollPane(table_select);
		
		add = new JButton("�ֹ�ǥ�� ���");
		delete = new JButton("����");
		order = new JButton("�ֹ��ϱ�");
		
		menuBar = new JMenuBar();
		menu_sort = new JMenu("���ı��� ��");
		menu_filter = new JMenu("���� ��");
		menu_waiting = new JMenu("��� ��� ����");
		
		mi_low = new JMenuItem("���ݳ�����");
		mi_high = new JMenuItem("���ݳ�����");
		mi_all = new JMenuItem("��ü");
		mi_casual = new JMenuItem("�нķ�");
		mi_meal = new JMenuItem("�Ļ��");
		mi_fried = new JMenuItem("Ƣ���");
		mi_beverage = new JMenuItem("����");
		mi_waiting = new JMenuItem("��� ��� ����");
	}
	
	void prepare() {
		table_menu.addMouseListener(new TableCommand(table_menu, add));
		table_select.addMouseListener(new TableCommand(table_select, delete));
		
		/*======= Command Pattern ���� : �� ����� ������ Command Ŭ������ ����� �����ʷ� ��� =======*/
		add.addActionListener(new AddCommand(this));
		delete.addActionListener(new DeleteCommand(this));
		order.addActionListener(new OrderCommand(this));
		
		mi_low.addActionListener(new SortByLowCommand(this));
		mi_high.addActionListener(new SortByHighCommand(this));
		mi_all.addActionListener(new FilterAllCommand(this));
		mi_casual.addActionListener(new FilterCommand(this, "�нķ�"));
		mi_meal.addActionListener(new FilterCommand(this, "�Ļ��"));
		mi_fried.addActionListener(new FilterCommand(this, "Ƣ���"));
		mi_beverage.addActionListener(new FilterCommand(this, "����"));
		mi_waiting.addActionListener(new WaitingCommand());
		
		menu_sort.add(mi_low);
		menu_sort.add(mi_high);
		menu_filter.add(mi_all);
		menu_filter.add(mi_casual);
		menu_filter.add(mi_meal);
		menu_filter.add(mi_fried);
		menu_filter.add(mi_beverage);
		menu_waiting.add(mi_waiting);
		
		menuBar.add(menu_sort);
		menuBar.add(menu_filter);
		menuBar.add(menu_waiting);
		
		order.setPreferredSize(new Dimension(1100, 50));
		
		add.setEnabled(false);
		delete.setEnabled(false);
		order.setEnabled(false);
	}
	
	void build() {
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		container.add(scroll_menu);
		container.add(add);
		container.add(scroll_select);
		container.add(delete);
		container.add(order);
		
		frame.setJMenuBar(menuBar);
		frame.setSize(1130, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void display() {
		frame.setVisible(true);
	}
}