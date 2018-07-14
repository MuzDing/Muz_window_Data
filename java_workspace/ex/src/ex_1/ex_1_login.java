package ex_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex_1_login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Name;
	private JPasswordField txt_Password;
	private static int exp;              //Ա���ȼ�
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex_1_login frame = new ex_1_login();
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
	ex_interface fr;     //����һ��ex_interface����
	public void share(ex_interface frm)
	{
		fr=frm;	   //���������fr������¼����
	}
	
	public ex_1_login() {
		moVe();         //����������
		}

	public void moVe(){	
		getContentPane().setLayout(null);
		setFocusable(false);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(148, 102, 93, 23);
		getContentPane().add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btn_Enter = new JButton("\u786E\u5B9A");
		btn_Enter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Connection con;
				try{
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����  
			        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // ���ӷ����������ݿ�  
			        String userName = "sa"; // Ĭ���û���  
			        String userPwd = "123456"; // ����  
			        Class.forName(driverName);  	      
			
					con = DriverManager.getConnection(dbURL,userName,userPwd);  //�������ݿ�
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);   
					stmt.executeUpdate("use test");
					
					String SQL = "select * from users where Cuser	 ='"+txt_Name.getText()+"'";      //�����������Ϣ����Ա����Ϣ
					//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					ResultSet rs= stmt.executeQuery(SQL);	       //rs��ȡ���ص����ݼ�
					  //��������ʾ����		
					rs.next();
					String str_temp=rs.getString("Cuser");  
					String str_temp1=rs.getString("Cpw");
					int ex = Integer.parseInt(rs.getString("exp"));
					if(txt_Name.getText().equalsIgnoreCase(str_temp) && txt_Password.getText().equalsIgnoreCase(str_temp1) )
					{	
						JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							dispose();    //�رմ˴���
							fr.setVisible(true);
							System.out.print(ex);
							if(2==ex)
							{
								fr.handButton();           //�������ͨԱ�������д˲���
							}
							
						//	ex_interface frame = new ex_interface();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������˺�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch(ClassNotFoundException e1){
						System.out.println("database driver not found");
					}
					catch(SQLException e1)
					{
						System.out.println("ERROR opening the db connection:" + e1.getMessage());
						JOptionPane.showMessageDialog(null, "�������������Ƿ��ظ�,�Ƿ����", "��ʾ", JOptionPane.ERROR_MESSAGE); 
					}				
			}
		});
		btn_Enter.setBounds(54, 185, 93, 23);
		contentPane.add(btn_Enter);
		
		JButton btn_Quit = new JButton("\u53D6\u6D88");
		btn_Quit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
		});
		btn_Quit.setBounds(201, 185, 93, 23);
		contentPane.add(btn_Quit);
		
		txt_Name = new JTextField();
		txt_Name.setBounds(144, 75, 98, 21);
		contentPane.add(txt_Name);
		txt_Name.setColumns(10);
		
		JLabel lbl_Name = new JLabel("\u8D26\u53F7\uFF1A");
		lbl_Name.setBounds(84, 78, 36, 15);
		contentPane.add(lbl_Name);
		
		JLabel lbl_Password = new JLabel("\u5BC6\u7801\uFF1A");
		lbl_Password.setBounds(84, 122, 41, 21);
		contentPane.add(lbl_Password);
		
		txt_Password = new JPasswordField();
		txt_Password.setBounds(144, 122, 98, 21);
		contentPane.add(txt_Password);

	}
}
