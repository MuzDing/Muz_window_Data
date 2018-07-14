package ex4_3;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class change extends JFrame {

	private JPanel contentPane;
	private JTextField txt_num;
	private JTextField txt_name;
	private JTextField txt_date;
	private JTextField txt_sex;
	private JTextField txt_college;
	private JTextField txt_home;
	private JTextField txt_class;
	private JTextField txt_major;
	private JTextField txt_home_tel;
	private JTextField txt_my_tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change frame = new change();
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
	public change() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 35, 735, 377);
		contentPane.add(panel);
		
		JLabel label = new JLabel("学号：");
		label.setBounds(77, 50, 36, 22);
		panel.add(label);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(77, 110, 36, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("班级：");
		label_2.setBounds(77, 174, 36, 22);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("姓名：");
		label_3.setBounds(289, 50, 61, 22);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("出生日期：");
		label_4.setBounds(499, 50, 61, 22);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("学院：");
		label_5.setBounds(289, 110, 61, 22);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("专业：");
		label_6.setBounds(289, 174, 61, 22);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("家庭住址：");
		label_7.setBounds(499, 110, 61, 22);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("家庭电话：");
		label_8.setBounds(499, 182, 61, 22);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("本人电话：");
		label_9.setBounds(54, 240, 61, 22);
		panel.add(label_9);
		
		JButton btn_sure = new JButton("确定");
		btn_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handle();
			}
		});
		btn_sure.setBounds(246, 301, 93, 34);
		panel.add(btn_sure);
		
		JButton btn_quit = new JButton("取消");
		btn_quit.setBounds(386, 301, 93, 34);
		panel.add(btn_quit);
		
		txt_num = new JTextField();
		txt_num.setEnabled(false);
		txt_num.setColumns(10);
		txt_num.setBounds(123, 47, 66, 21);
		panel.add(txt_num);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(349, 47, 66, 21);
		panel.add(txt_name);
		
		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(569, 47, 114, 21);
		panel.add(txt_date);
		
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(123, 107, 66, 21);
		panel.add(txt_sex);
		
		txt_college = new JTextField();
		txt_college.setColumns(10);
		txt_college.setBounds(349, 107, 66, 21);
		panel.add(txt_college);
		
		txt_home = new JTextField();
		txt_home.setColumns(10);
		txt_home.setBounds(570, 111, 113, 21);
		panel.add(txt_home);
		
		txt_class = new JTextField();
		txt_class.setColumns(10);
		txt_class.setBounds(123, 175, 66, 21);
		panel.add(txt_class);
		
		txt_major = new JTextField();
		txt_major.setColumns(10);
		txt_major.setBounds(349, 175, 66, 21);
		panel.add(txt_major);
		
		txt_home_tel = new JTextField();
		txt_home_tel.setColumns(10);
		txt_home_tel.setBounds(570, 175, 113, 21);
		panel.add(txt_home_tel);
		
		txt_my_tel = new JTextField();
		txt_my_tel.setColumns(10);
		txt_my_tel.setBounds(123, 241, 66, 21);
		panel.add(txt_my_tel);
		this.setVisible(true);
	}
	public void handle()
	{
		int i = Integer.parseInt(txt_date.getText());
		if(i<0 || i>120)
		{
			JOptionPane.showMessageDialog(null, "年龄应大于0小于120", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		i=Integer.parseInt(txt_home_tel.getText());
		if(i/1000000000 == 0)
		{
			JOptionPane.showMessageDialog(null, "手机号必须11位", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		i=Integer.parseInt(txt_my_tel.getText());
		if(i/1000000000 == 0)
		{
			JOptionPane.showMessageDialog(null, "手机号必须11位", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		
		
		Connection connection;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306";
			String username = "root";
			String userpassword = "admin";
			connection = DriverManager.getConnection(dbURL,username,"admin");
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("use test");
			stmt.executeUpdate("update student set sname='"+txt_name.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set sdate='"+txt_date.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set ssex='"+txt_sex.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set scollege='"+txt_college.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set sclass='"+txt_class.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set smajor='"+txt_major.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set shome='"+txt_home.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set shometel='"+txt_home_tel.getText()+"' where snum='"+txt_num.getText()+"'");
			stmt.executeUpdate("update student set stel='"+txt_my_tel.getText()+"' where snum='"+txt_num.getText()+"'");
			
			//stmt.executeUpdate("update student set sname='"+txt_name.getText()+"',sdate = '"+txt_date.getText()+"',ssex ='"+txt_sex.getText()+"',smajor='"+txt_major.getText()+"',sclass ='"+txt_home.getText()+"',shometel='"+txt_home_tel.getText()+"',stel='"+txt_my_tel.getText() +"'where snum=' "+txt_num.getText()+"'");
			JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.ERROR_MESSAGE); 
			
			stmt.close();
			txt_num.setText("");
			txt_name.setText("");
			txt_date.setText("");
			txt_sex.setText("");
			txt_college.setText("");
			txt_class.setText("");
			txt_major.setText("");
			txt_home.setText("");
			txt_home_tel.setText("");
			txt_my_tel.setText("");
			
			
		}
		catch(ClassNotFoundException e){
			System.out.println("database driver not found");
		}
		catch(SQLException e)
		{
			System.out.println("ERROR opening the db connection:" + e.getMessage());
		}
	}
	public void display(ResultSet rs) {
		try {
			while(rs.next())
			{
				txt_num.setText(rs.getString("snum")); 
				txt_name.setText(rs.getString("sname")); 
				txt_date.setText(rs.getString("sdate")); 
				txt_sex.setText(rs.getString("ssex")); 
				txt_college.setText(rs.getString("scollege")); 
				txt_major.setText(rs.getString("smajor")); 
				txt_class.setText(rs.getString("sclass")); 
				txt_home.setText(rs.getString("shome")); 
				txt_home_tel.setText(rs.getString("shometel")); 
				txt_my_tel.setText(rs.getString("stel")); 
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
