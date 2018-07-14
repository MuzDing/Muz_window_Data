package ex4_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Student extends JFrame {

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
		
		mysql sql = new mysql(); 			//连接数据库
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lab_num = new JLabel("\u5B66\u53F7\uFF1A");
		lab_num.setBounds(77, 50, 36, 22);
		contentPane.add(lab_num);
		
		JLabel lab_sex = new JLabel("\u6027\u522B");
		lab_sex.setBounds(77, 110, 36, 22);
		contentPane.add(lab_sex);
		
		JLabel lab_class = new JLabel("\u73ED\u7EA7\uFF1A");
		lab_class.setBounds(77, 174, 36, 22);
		contentPane.add(lab_class);
		
		JLabel lab_name = new JLabel("\u59D3\u540D\uFF1A");
		lab_name.setBounds(289, 50, 61, 22);
		contentPane.add(lab_name);
		
		JLabel lab_date = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lab_date.setBounds(499, 50, 61, 22);
		contentPane.add(lab_date);
		
		JLabel lab_college = new JLabel("\u5B66\u9662\uFF1A");
		lab_college.setBounds(289, 110, 61, 22);
		contentPane.add(lab_college);
		
		JLabel lab_major = new JLabel("\u4E13\u4E1A\uFF1A");
		lab_major.setBounds(289, 174, 61, 22);
		contentPane.add(lab_major);
		
		JLabel lab_home = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		lab_home.setBounds(499, 110, 61, 22);
		contentPane.add(lab_home);
		
		JLabel lab_home_tel = new JLabel("\u5BB6\u5EAD\u7535\u8BDD\uFF1A");
		lab_home_tel.setBounds(499, 182, 61, 22);
		contentPane.add(lab_home_tel);
		
		JLabel lab_my_tel = new JLabel("\u672C\u4EBA\u7535\u8BDD\uFF1A");
		lab_my_tel.setBounds(54, 240, 61, 22);
		contentPane.add(lab_my_tel);
		
		JButton btn_add = new JButton("\u6DFB\u52A0");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(txt_date.getText());
				if(i<0 || i>120)
				{
					error e = new error(i);
				}
				i=Integer.parseInt(txt_home_tel.getText());
				if(i/1000000000 == 0)
				{
					error e = new error(i); 
				}
				i=Integer.parseInt(txt_my_tel.getText());
				if(i/1000000000 == 0)
				{
					error e = new error(i);
				}
				handle(1);
				
			}
		});
		btn_add.setBounds(64, 341, 93, 34);
		contentPane.add(btn_add);
		
		JButton btn_change = new JButton("\u4FEE\u6539");
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				handle(3);
			}
		});
		btn_change.setBounds(195, 341, 93, 34);
		contentPane.add(btn_change);
		
		JButton btn_del = new JButton("\u5220\u9664");
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handle(2);
			}
		});
		btn_del.setBounds(331, 341, 93, 34);
		contentPane.add(btn_del);
		
		JButton btn_show = new JButton("显示");
		btn_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handle(5);
			}
		});
		btn_show.setBounds(590, 341, 93, 34);
		contentPane.add(btn_show);
		
		txt_num = new JTextField();
		txt_num.setBounds(123, 47, 66, 21);
		contentPane.add(txt_num);
		txt_num.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(349, 47, 66, 21);
		contentPane.add(txt_name);
		
		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(569, 47, 114, 21);
		contentPane.add(txt_date);
		
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(123, 107, 66, 21);
		contentPane.add(txt_sex);
		
		txt_college = new JTextField();
		txt_college.setColumns(10);
		txt_college.setBounds(349, 107, 66, 21);
		contentPane.add(txt_college);
		
		txt_home = new JTextField();
		txt_home.setColumns(10);
		txt_home.setBounds(570, 111, 113, 21);
		contentPane.add(txt_home);
		
		txt_class = new JTextField();
		txt_class.setColumns(10);
		txt_class.setBounds(123, 175, 66, 21);
		contentPane.add(txt_class);
		
		txt_major = new JTextField();
		txt_major.setColumns(10);
		txt_major.setBounds(349, 175, 66, 21);
		contentPane.add(txt_major);
		
		txt_home_tel = new JTextField();
		txt_home_tel.setColumns(10);
		txt_home_tel.setBounds(570, 175, 113, 21);
		contentPane.add(txt_home_tel);
		
		txt_my_tel = new JTextField();
		txt_my_tel.setColumns(10);
		txt_my_tel.setBounds(123, 241, 66, 21);
		contentPane.add(txt_my_tel);
		
		JButton btn_select = new JButton("查询");
		btn_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handle(4);
			}
		});
		btn_select.setBounds(469, 344, 93, 29);
		contentPane.add(btn_select);
		
		String str="";
		int x= (int) (1+(Math.random()*1000));
		if(x/100 == 0)
			str="0"+x;
		else
			str=""+x;
		JLabel lbl_two = new JLabel("");
		lbl_two.setFont(new Font("",1,30));//设置字体大小
		lbl_two.setForeground(Color.RED);
		lbl_two.setBounds(279, 277, 281, 42);
		contentPane.add(lbl_two);
		lbl_two.setText("3D今天推荐号:"+str+"");
		
		String food[]={"饺子","面条","米饭","混沌","黄焖鸡","馒头","明炉","菜饭","烤肉饭","凉皮"};
		JLabel lbl_one = new JLabel("");
		lbl_one.setForeground(Color.RED);
		lbl_one.setBounds(279, 234, 293, 34);
		contentPane.add(lbl_one);
		lbl_one.setFont(new Font("",1,30));//设置字体大小
		int x1= (int) ((Math.random()*10));
		lbl_one.setText("今天适合吃:"+food[x1]+"");
		
		
		
		this.setVisible(true);
	}
	public void handle(int flag)
	{
		Connection connection;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306";
			String username = "root";
			String userpassword = "admin";
			connection = DriverManager.getConnection(dbURL,username,"admin");
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("use test");
			
			if(flag ==1)
			{
				stmt.executeUpdate("insert into student values('"+txt_num.getText()+"','"+txt_name.getText()+"','"+txt_date.getText()+"','"+txt_sex.getText()+"','"+txt_college.getText()+"','"+txt_major.getText()+"','"+txt_class.getText()+"','"+txt_home.getText()+"','"+txt_home_tel.getText()+"','"+txt_my_tel.getText()+"')");
				JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.ERROR_MESSAGE); 
			}
			if(flag ==2)
			{
				String inputValue = JOptionPane.showInputDialog("Please input a num"); 
				stmt.executeUpdate("delete from student where snum = '" +inputValue+ "'");
				JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.ERROR_MESSAGE); 
			}
			if(flag ==3)
			{
				ResultSet rs = stmt.executeQuery("select * from student where snum = '"+ txt_num.getText()+"'");	
				change frm = new change();
				frm.display(rs);
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

			}
			if(flag ==4)
			{
				ResultSet rs = stmt.executeQuery("select * from student where snum = '"+ txt_num.getText()+"'");	
				JOptionPane.showMessageDialog(null, "查询成功", "提示", JOptionPane.ERROR_MESSAGE); 
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
			}
			if(flag == 5)
			{
				ResultSet rs = stmt.executeQuery("select * from student ");	
				data frm = new data();
				frm.display(rs);
			}
		/*	ResultSet rs = stmt.executeQuery("select * from student");
			
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
			}*/ 
			stmt.close();
			
		}
		catch(ClassNotFoundException e){
			System.out.println("database driver not found");
		}
		catch(SQLException e)
		{
			System.out.println("ERROR opening the db connection:" + e.getMessage());
			JOptionPane.showMessageDialog(null, "错误，请检查数据是否重复,是否出错", "提示", JOptionPane.ERROR_MESSAGE); 
		}
	}
}
