package ex_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex_change extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Num;
	private JTextField txt_Name;
	private JTextField txt_Cname;
	private JTextField txt_Price;
	private JTextField txt_Size;
	private JTextField txt_Count;
	private JTextField txt_Inf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex_change frame = new ex_change();
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
	public ex_change() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setBounds(47, 50, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u540D\u79F0\uFF1A");
		label_1.setBounds(47, 75, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5382\u5BB6\uFF1A");
		label_2.setBounds(47, 143, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		label_3.setBounds(47, 184, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u578B\u53F7\uFF1A");
		label_4.setBounds(47, 110, 54, 15);
		panel.add(label_4);
		
		txt_Num = new JTextField();
		txt_Num.setEnabled(false);
		txt_Num.setColumns(10);
		txt_Num.setBounds(87, 47, 107, 21);
		panel.add(txt_Num);
		
		txt_Name = new JTextField();
		txt_Name.setColumns(10);
		txt_Name.setBounds(87, 78, 107, 21);
		panel.add(txt_Name);
		
		txt_Cname = new JTextField();
		txt_Cname.setColumns(10);
		txt_Cname.setBounds(87, 140, 107, 21);
		panel.add(txt_Cname);
		
		txt_Price = new JTextField();
		txt_Price.setColumns(10);
		txt_Price.setBounds(87, 175, 107, 21);
		panel.add(txt_Price);
		
		txt_Size = new JTextField();
		txt_Size.setColumns(10);
		txt_Size.setBounds(87, 107, 107, 21);
		panel.add(txt_Size);
		
		txt_Count = new JTextField();
		txt_Count.setColumns(10);
		txt_Count.setBounds(87, 206, 107, 21);
		panel.add(txt_Count);
		
		JButton btn_Sure = new JButton("\u786E\u5B9A");
		btn_Sure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle();																		//执行修改函数
				
			}
		});
		btn_Sure.setBounds(239, 106, 93, 23);
		panel.add(btn_Sure);
		
		JButton btn_Quit = new JButton("\u53D6\u6D88");
		btn_Quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();																			//退出修改操作
			}
		});
		btn_Quit.setBounds(239, 180, 93, 23);
		panel.add(btn_Quit);
		
		JLabel label_5 = new JLabel("\u6570\u91CF\uFF1A");
		label_5.setBounds(47, 209, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u9644\u52A0\uFF1A");
		label_6.setBounds(47, 238, 54, 15);
		panel.add(label_6);
		
		txt_Inf = new JTextField();
		txt_Inf.setColumns(10);
		txt_Inf.setBounds(87, 235, 107, 21);
		panel.add(txt_Inf);
		setVisible(true);
	}
	//显示数据在修改界面上
	public void display(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				txt_Num.setText(rs.getString("Cnum")); 
				txt_Name.setText(rs.getString("Cname")); 
				txt_Size.setText(rs.getString("Csize")); 
				txt_Cname.setText(rs.getString("Ccname")); 
				txt_Price.setText(rs.getString("Cprice")); 
				txt_Count.setText(rs.getString("Ccount")); 
				txt_Inf.setText(rs.getString("Cinf")); 				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	public void handle()
	{		
		Connection connection;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		//加载数据库驱动
			String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test";		//数据库
			String username = "sa";										
			String userpassword = "123456";
			connection = DriverManager.getConnection(dbURL,username,userpassword);  //连接数据库
			Statement stmt = connection.createStatement();						
			stmt.executeUpdate("use test");													//修改信息
			stmt.executeUpdate("update test set Cname='"+txt_Name.getText()+"' where Cnum='"+txt_Num.getText()+"'");
			stmt.executeUpdate("update test set Csize='"+txt_Size.getText()+"' where Cnum='"+txt_Num.getText()+"'");
			stmt.executeUpdate("update test set Ccname='"+txt_Cname.getText()+"' where Cnum='"+txt_Num.getText()+"'");
			stmt.executeUpdate("update test set Cprice='"+txt_Price.getText()+"' where Cnum='"+txt_Num.getText()+"'");
			stmt.executeUpdate("update test set Ccount='"+txt_Count.getText()+"' where Cnum='"+txt_Num.getText()+"'");
			stmt.executeUpdate("update test set Cinf='"+txt_Inf.getText()+"' where Cnum='"+txt_Num.getText()+"'");

			//stmt.executeUpdate("update student set sname='"+txt_name.getText()+"',sdate = '"+txt_date.getText()+"',ssex ='"+txt_sex.getText()+"',smajor='"+txt_major.getText()+"',sclass ='"+txt_home.getText()+"',shometel='"+txt_home_tel.getText()+"',stel='"+txt_my_tel.getText() +"'where snum=' "+txt_num.getText()+"'");
			JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE); 
			
			stmt.close();				
			txt_Num.setText(""); 
			txt_Name.setText(""); 
			txt_Size.setText(""); 
			txt_Cname.setText(""); 
			txt_Price.setText(""); 
			txt_Count.setText(""); 
			txt_Inf.setText("");
			
		}
		catch(ClassNotFoundException e){
			System.out.println("database driver not found");
		}
		catch(SQLException e)
		{
			System.out.println("ERROR opening the db connection:" + e.getMessage());
		}
	}
}
