package ex_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ex_del extends JFrame {
	private JTextField txt_Num;
	private JTextField txt_Count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex_del frame = new ex_del();
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
	public ex_del() {
		super("��Ʒ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 356, 300);
		getContentPane().setLayout(null);
		
		txt_Num = new JTextField();
		txt_Num.setBounds(148, 84, 66, 21);
		getContentPane().add(txt_Num);
		txt_Num.setColumns(10);
		
		txt_Count = new JTextField();
		txt_Count.setBounds(148, 146, 66, 21);
		getContentPane().add(txt_Count);
		txt_Count.setColumns(10);
		
		JButton btn_Sure = new JButton("\u786E\u5B9A");
		btn_Sure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = 0;
				Connection con = null;
				try {
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����  
			        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // ���ӷ����������ݿ�  
			        String userName = "sa"; // Ĭ���û���  
			        String userPwd = "123456"; // ����  
			        Class.forName(driverName);  	     
			
					con = DriverManager.getConnection(dbURL,userName,userPwd);
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);   
					
					stmt.executeUpdate("use test");
					String SQL = "select * from test where Cnum ='"+txt_Num.getText()+"'";   
					//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					ResultSet rs= stmt.executeQuery(SQL);	                     //��ȡ���ݼ�
					  //��������ʾ����		
					rs.next();
					temp=Integer.parseInt(rs.getString("Ccount"));                       //��ȡ��װ������
					int temp2 = Integer.parseInt(txt_Count.getText());						//��ȡ���������
					int temp3=temp-temp2;														//������ж�������
					stmt.executeUpdate("update test set Ccount='"+temp3+"' where Cnum='"+txt_Num.getText()+"'");   //ִ���޸���䣬�޸Ŀ��
					if(temp3<=0)																		//������С��0��ɾ������Ʒ
						stmt.executeUpdate("delete from test where Cnum = '" +txt_Num.getText()+ "'");          //ֻɾ�����
					
					Date date=new Date();                       //�½�ʱ�����
					  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //��ȡ����ʱ��
					  String time=format.format(date);         //����������ת��Ϊ�ַ���
					  
					stmt.executeUpdate("insert into Record values('"+time+"','"+txt_Num.getText()+"','"+txt_Count.getText()+"')");   //�����¼
					
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					stmt.close();
				}
				 catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}      	  
				
				dispose();
			}
		});
		btn_Sure.setBounds(110, 187, 93, 33);
		getContentPane().add(btn_Sure);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(84, 87, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_1.setBounds(84, 149, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		setVisible(true);
	}
}
