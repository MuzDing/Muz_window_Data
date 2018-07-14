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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ex_interface extends JFrame {
	
	private JPanel contentPane;
	private JTextField txt_Num;
	private JTextField txt_Name;
	private JTextField txt_Cname;
	private JTextField txt_Price;
	private JTextField txt_Size;
	private JTextField txt_Count;
	private JButton btn_Add;
	public static JButton btn_Change;
	public static JButton btn_Del;
	private JButton btn_All;
	private JButton btn_Pass;
	private JButton btn_Record;
	private JButton btn_Search;
	private JLabel lbl_Count;
	private JTextField txt_Inf;

	private static int exp=0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			//    ex_db db = new ex_db();
				showT();                           
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static void showT()
	{
		try {
			ex_interface frame = new ex_interface();                     //创建一个主界面
			frame.setVisible(false);												//设置主界面不显示
			ex_1_login frm = new ex_1_login();								//创建登陆界面
			frm.share(frame);														//将主界面的参数传递到登录界面
			frm.setVisible(true);													//设置登陆几面显示
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ex_interface() {
						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Num = new JLabel("\u7F16\u53F7\uFF1A");
		lbl_Num.setBounds(47, 50, 54, 15);
		contentPane.add(lbl_Num);
		
		JLabel lbl_Name = new JLabel("\u540D\u79F0\uFF1A");
		lbl_Name.setBounds(47, 75, 54, 15);
		contentPane.add(lbl_Name);
		
		JLabel lbl_Cname = new JLabel("\u5382\u5BB6\uFF1A");
		lbl_Cname.setBounds(47, 143, 54, 15);
		contentPane.add(lbl_Cname);
		
		JLabel lbl_Price = new JLabel("\u4EF7\u683C\uFF1A");
		lbl_Price.setBounds(47, 184, 54, 15);
		contentPane.add(lbl_Price);
		
		JLabel lbl_Size = new JLabel("\u578B\u53F7\uFF1A");
		lbl_Size.setBounds(47, 110, 54, 15);
		contentPane.add(lbl_Size);
		
		txt_Num = new JTextField();
		txt_Num.setBounds(87, 47, 107, 21);
		contentPane.add(txt_Num);
		txt_Num.setColumns(10);
		
		txt_Name = new JTextField();
		txt_Name.setColumns(10);
		txt_Name.setBounds(87, 78, 107, 21);
		contentPane.add(txt_Name);
		
		txt_Cname = new JTextField();
		txt_Cname.setColumns(10);
		txt_Cname.setBounds(87, 140, 107, 21);
		contentPane.add(txt_Cname);
		
		txt_Price = new JTextField();
		txt_Price.setColumns(10);
		txt_Price.setBounds(87, 175, 107, 21);
		contentPane.add(txt_Price);
		
		txt_Size = new JTextField();
		txt_Size.setColumns(10);
		txt_Size.setBounds(87, 107, 107, 21);
		contentPane.add(txt_Size);
		
		txt_Count = new JTextField();
		txt_Count.setColumns(10);
		txt_Count.setBounds(87, 206, 107, 21);
		contentPane.add(txt_Count);
		
		btn_Add = new JButton("\u5546\u54C1\u6DFB\u52A0");
		btn_Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_Num.getText() == null || txt_Num.getText().length() <= 0)										//如果添加的编号信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "编号不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
				if(txt_Name.getText() == null || txt_Name.getText().length() <= 0)										//如果添加的名字信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "名字不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}if(txt_Size.getText() == null || txt_Size.getText().length() <= 0)										//如果添加的型号信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "型号不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}if(txt_Cname.getText() == null || txt_Cname.getText().length() <= 0)										//如果添加的厂家信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "厂家不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}if(txt_Price.getText() == null || txt_Price.getText().length() <= 0)										//如果添加的价格信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "价格不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}if(txt_Count.getText() == null || txt_Count.getText().length() <= 0)										//如果添加的数量信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "数量不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
				handle(1);																//执行添加操作
			}
		});
		
		btn_Add.setBounds(239, 91, 93, 23);
		contentPane.add(btn_Add);
		
		btn_Change = new JButton("\u5546\u54C1\u4FEE\u6539");
		btn_Change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_Num.getText() == null || txt_Num.getText().length() <= 0)										//如果添加的编号信息为空，请重新添加
				{
					JOptionPane.showMessageDialog(null, "编号不能为空", "提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
				 handle(3);   									 //执行修改操作
			}
		});
		btn_Change.setBounds(239, 50, 93, 23);
		contentPane.add(btn_Change);
		
		btn_Del = new JButton("\u5546\u54C1\u9500\u552E");
		btn_Del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle(2);																			//执行销售操作
			}
		});
		btn_Del.setBounds(239, 139, 93, 23);
		contentPane.add(btn_Del);
		
		btn_All = new JButton("\u5546\u54C1\u663E\u793A");
		btn_All.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle(5);																		//执行显示信息操作
			}
		});
		btn_All.setBounds(239, 230, 93, 23);
		contentPane.add(btn_All);
		
		btn_Search = new JButton("\u5546\u54C1\u67E5\u8BE2");
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle(4); 																	//执行查询操作
			}
		});
		btn_Search.setBounds(239, 184, 93, 23);
		contentPane.add(btn_Search);
		
		lbl_Count = new JLabel("\u6570\u91CF\uFF1A");
		lbl_Count.setBounds(47, 209, 54, 15);
		contentPane.add(lbl_Count);
		
		JLabel lbl_Inf = new JLabel("\u9644\u52A0\uFF1A");
		lbl_Inf.setBounds(47, 238, 54, 15);
		contentPane.add(lbl_Inf);
		
		txt_Inf = new JTextField();
		txt_Inf.setColumns(10);
		txt_Inf.setBounds(87, 235, 107, 21);
		contentPane.add(txt_Inf);
		
		btn_Pass = new JButton("\u5546\u54C1\u5220\u9664");
		btn_Pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle(6);							//执行删除操作
			}
		});
		btn_Pass.setBounds(37, 10, 93, 23);
		contentPane.add(btn_Pass);
		
		btn_Record = new JButton("\u9500\u552E\u8BB0\u5F55");
		btn_Record.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handle(7);									//	执行查看销售记录操作
			}
		});
		btn_Record.setBounds(172, 10, 93, 23);
		contentPane.add(btn_Record);
		
		setVisible(true);
		
	}
	
	public void handle(int flag)
	{
		Connection con;
		try{
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动  
	        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // 连接服务器和数据库  
	        String userName = "sa"; // 默认用户名  
	        String userPwd = "123456"; // 密码  
	        Class.forName(driverName);  	     
	
			con = DriverManager.getConnection(dbURL,userName,userPwd);                     //连接数据库
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);      
			stmt.executeUpdate("use test");
			
			if(flag ==1)
			{
				stmt.executeUpdate("insert into test values('"+txt_Num.getText()+"','"+txt_Name.getText()+"','"+txt_Size.getText()+"','"+txt_Cname.getText()+"','"+txt_Price.getText()+"','"+txt_Count.getText()+"','"+txt_Inf.getText()+"')");
				JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.ERROR_MESSAGE);
				stmt.close();
			}
			if(flag ==2)
			{
				//stmt.executeUpdate("update test set Ccount='"+txt_Count.getText()+"' where Cnum='"+txt_Num.getText()+"'");
				ex_del frm = new ex_del();            //转入销售页面
			//	JOptionPane.showMessageDialog(null, "销售成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
			if(flag ==3)
			{
				ResultSet rs = stmt.executeQuery("select * from test where Cnum = '"+ txt_Num.getText()+"'");	      //查询该编号的所有信息
				ex_change frm = new ex_change();                                         					//转入修改页面
				frm.display(rs);																						//发送数据集
				while(rs.next())																						//显示服装信息
				{
					txt_Num.setText(rs.getString("Cnum")); 
					txt_Name.setText(rs.getString("Cname")); 
					txt_Size.setText(rs.getString("Csize")); 
					txt_Cname.setText(rs.getString("Cname")); 
					txt_Price.setText(rs.getString("Cprice")); 
					txt_Count.setText(rs.getString("Ccount")); 
					txt_Inf.setText(rs.getString("Cinf"));			
				}
   
			}
			if(flag ==4)
			{
				String inputValue = JOptionPane.showInputDialog("请输入编号或者名称");											//弹出对话框
				ResultSet rs = stmt.executeQuery("select * from test where Cnum = '"+inputValue +"'or Cname ='"+inputValue +"'");		//获取数据集
				
				while(rs.next())
				{
					txt_Num.setText(rs.getString("Cnum")); 
					txt_Name.setText(rs.getString("Cname")); 
					txt_Size.setText(rs.getString("Csize")); 
					txt_Cname.setText(rs.getString("Cname")); 
					txt_Price.setText(rs.getString("Cprice")); 
					txt_Count.setText(rs.getString("Ccount")); 
					txt_Inf.setText(rs.getString("Cinf"));		
				}
			}
			if(flag == 5)
			{
				ResultSet rs = stmt.executeQuery("select * from test ");	      //获取数据集
				ex_data frm = new ex_data();											//新建数据显示窗口
				frm.display(rs,1);																	//	传送数据集
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
			if(flag==6)
			{
				String inputValue = JOptionPane.showInputDialog("Please input a num");                         //弹出对话框
				stmt.executeUpdate("delete from test where Cnum = '" +inputValue+ "'");							//执行删除语句
			}
			if(flag ==7)
			{
				ResultSet rs = stmt.executeQuery("select * from Record ");								//查询数据集
				ex_data frm = new ex_data();																		//新建数据显示窗口
				frm.display(rs,2);																									//发送数据集
			}
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
	public void handButton()
	{
		btn_Change.setVisible(false);										//修改按钮隐藏
		btn_Pass.setVisible(false);									//删除按钮隐藏
		btn_Record.setVisible(false);										//查看记录按钮隐藏
		btn_Add.setVisible(false);											//添加按钮隐藏
		
	}
	
}
