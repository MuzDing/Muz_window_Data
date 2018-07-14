package ex4_3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class data extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					data frame = new data();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
	}
	int rows=0; //总记录行
	int row=0;	//当前记录行
	String records[][];
	String columnNames[]={"学号","姓名","出生年月","性别","学院","专业","班级","家庭住址","家庭电话","本人电话"};
	public void display(ResultSet rs) {
		
		try {
			
			rs.last();
			rows=rs.getRow();
			records = new String[rows][10];
			int row = 0;
			rs.beforeFirst();
			while(rs.next())
			{
				records[row][0]=rs.getString(1);
				records[row][1]=rs.getString(2);
				records[row][2]=rs.getString(3);
				records[row][3]=rs.getString(4);
				records[row][4]=rs.getString(5);
				records[row][5]=rs.getString(6);
				records[row][6]=rs.getString(7);
				records[row][7]=rs.getString(8);
				records[row][8]=rs.getString(9);
				records[row][9]=""+rs.getString(10);
				row++;
				
			}
			rs.close();
				
	
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//DefaultTableModel model = new DefaultTableModel();
		table = new JTable(records,columnNames);
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane,BorderLayout.CENTER);
		JPanel panel=new JPanel();
		getContentPane().add(panel,BorderLayout.SOUTH);
		table.setBounds(30, 30, 800, 600);
		getContentPane().add(table);

		setVisible(true);
		this.setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}
