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
		frame = new JFrame("셀프 주문 시스템 - " + TABLE_NUMBER + "번 테이블");
	}

	void run() {
		setup();
		prepare();
		build();
		display();
	}
	
	void setup() {
		container = frame.getContentPane();
		
		collum_menus = new String[]{"메뉴명", "메뉴설명", "가격"};
		collum_select = new String[]{"메뉴명", "가격"};
		
		/*======= Adapter Pattern 적용 : ArrayList로 구현된 메뉴 리스트를 2차원 배열로 =======*/
		menuAdapter = new MenuAdapter();
		menus = menuAdapter.getAllMenu();
		
		model_menu = new DefaultTableModel(menus, collum_menus);
		model_select = new DefaultTableModel(null, collum_select);
		
		table_menu = new JTable(model_menu);
		table_select = new JTable(model_select);
		
		scroll_menu = new JScrollPane(table_menu);			// 각 ScrollPane에 테이블 등록
		scroll_select = new JScrollPane(table_select);
		
		add = new JButton("주문표에 담기");
		delete = new JButton("삭제");
		order = new JButton("주문하기");
		
		menuBar = new JMenuBar();
		menu_sort = new JMenu("정렬기준 ▼");
		menu_filter = new JMenu("필터 ▼");
		menu_waiting = new JMenu("대기 목록 보기");
		
		mi_low = new JMenuItem("가격낮은순");
		mi_high = new JMenuItem("가격높은순");
		mi_all = new JMenuItem("전체");
		mi_casual = new JMenuItem("분식류");
		mi_meal = new JMenuItem("식사류");
		mi_fried = new JMenuItem("튀김류");
		mi_beverage = new JMenuItem("음료");
		mi_waiting = new JMenuItem("대기 목록 보기");
	}
	
	void prepare() {
		table_menu.addMouseListener(new TableCommand(table_menu, add));
		table_select.addMouseListener(new TableCommand(table_select, delete));
		
		/*======= Command Pattern 적용 : 각 명령을 수행할 Command 클래스를 만들어 리스너로 등록 =======*/
		add.addActionListener(new AddCommand(this));
		delete.addActionListener(new DeleteCommand(this));
		order.addActionListener(new OrderCommand(this));
		
		mi_low.addActionListener(new SortByLowCommand(this));
		mi_high.addActionListener(new SortByHighCommand(this));
		mi_all.addActionListener(new FilterAllCommand(this));
		mi_casual.addActionListener(new FilterCommand(this, "분식류"));
		mi_meal.addActionListener(new FilterCommand(this, "식사류"));
		mi_fried.addActionListener(new FilterCommand(this, "튀김류"));
		mi_beverage.addActionListener(new FilterCommand(this, "음료"));
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