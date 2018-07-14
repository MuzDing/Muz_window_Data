package ex4_3;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private String user="12";
	private String password="12";
	private JPasswordField passwordField;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_user = new JLabel("账号：");
		lbl_user.setBounds(107, 67, 54, 15);
		contentPane.add(lbl_user);
		
		txt_user = new JTextField();
		txt_user.setBounds(177, 64, 98, 21);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		JLabel lbl_password = new JLabel("密码：");
		lbl_password.setBounds(107, 114, 54, 15);
		contentPane.add(lbl_password);
		
		
		JButton btn_enter = new JButton("确定");
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt_user.getText().equals(user) && txt_password.getText().equals(password))/// && txt_password.getText() ==password)
				{
					Student s1 = new Student();
					setVisible(false);					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "账号密码错误", "提示", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btn_enter.setBounds(91, 169, 93, 23);
		contentPane.add(btn_enter);
		
		JButton btn_quit = new JButton("取消");
		btn_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		btn_quit.setBounds(211, 169, 93, 23);
		contentPane.add(btn_quit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 114, -94, 21);
		contentPane.add(passwordField);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(177, 111, 98, 21);
		contentPane.add(txt_password);
	}
}
