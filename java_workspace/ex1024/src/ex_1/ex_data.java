package ex_1;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ex_data extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex_data frame = new ex_data();
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
	public ex_data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	int rows=0; //总记录行
	int row=0;	//当前记录行
	String records[][];
	String Names[]={"编号","名称","型号","厂家","价格","数量","附加"};
	public void display(ResultSet rs,int flag) {
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
				if(1 == flag)
				{		records[row][3]=rs.getString(4);
						records[row][4]=rs.getString(5);
						records[row][5]=rs.getString(6);
						records[row][6]=""+rs.getString(7);
				}
				row++;
			}
			rs.close();	
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		//DefaultTableModel model = new DefaultTableModel();
		table = new JTable(records,Names);
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane,BorderLayout.CENTER);
		
		JPanel panel=new JPanel();
		getContentPane().add(panel,BorderLayout.SOUTH);
		table.setBounds(30, 30, 700, 600);
		getContentPane().add(table);

		setVisible(true);
		this.setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setColumnSize(0,140); //调整间距
		setColumnSize(1,100);
		setColumnSize(2,20);
		setColumnSize(3,100);
		
	}
	public void setColumnSize(int i, int width ) {
		  TableColumnModel   cm   =   table.getColumnModel();     //表格的列模型
		  TableColumn   column  = cm.getColumn(i);//得到第i个列对象   
		  column.setPreferredWidth(width);//将此列的首选宽度设置为 preferredWidth。
		  //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。 
		 }
}
