package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class ex extends JFrame {
	
	String Vn[] = { "E", "E'", "T", "T'", "F" }; // ���ս����
	String Vt[] = { "i", "+", "*", "(", ")", "#" }; // �ս����
	String P[][] = new String[5][6]; // Ԥ�������
	String fenxi[] ; // ����ջ
	int count = 1; // ����
	int count1 = 1;//������ջָ��
	int count2 = 0, count3 = 0;//Ԥ�������ָ��	
	String inputString = ""; // ������ַ���
	boolean flag;

	private JPanel contentPane;
	private JTextField txt_str;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex frame = new ex();
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
	public ex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_str = new JTextField();
		txt_str.setBounds(137, 55, 152, 31);
		contentPane.add(txt_str);
		txt_str.setColumns(10);
		
		JTextArea txt_1 = new JTextArea();
		txt_1.setBounds(24, 135, 404, 320);
		contentPane.add(txt_1);
		
		JTextArea txt_2 = new JTextArea();
		txt_2.setLineWrap(true);
		txt_2.setBounds(438, 135, 359, 331);
		contentPane.add(txt_2);

		
		setP(txt_1);
		
		JButton btn_ll1 = new JButton("\u5206\u6790");
		btn_ll1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				send(txt_2);
				 
				/* if(b){
					 System.out.println("��������ַ���"+inputString+"��LL1�ķ�");
				 }else{
					 System.out.println("��������ַ���"+inputString+"�дʷ�����");
				 } */
			}
		});
		btn_ll1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					send(txt_2);
				}
			}
		});
		btn_ll1.setBounds(373, 49, 105, 42);
		contentPane.add(btn_ll1);

		
	}
	public void send(JTextArea txt_2)
	{
		int lenght= txt_2.getText().length();
		 if(lenght>0)
			 txt_2.setText("");
		 inputString =txt_str.getText().trim(); 
		 setCount(1, 1, 0, 0);
		 setFenxi();
		 boolean b = judge(txt_2);
	}
	public void setP(JTextArea txt_1) { // ��ʼ��Ԥ�������
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				P[i][j] = "error";
			}
		}
		P[0][0] = "->TE'";
		P[0][3] = "->TE'";
		P[1][1] = "->+TE'";
		P[1][4] = "->��";
		P[1][5] = "->��";
		P[2][0] = "->FT'";
		P[2][3] = "->FT'";
		P[3][1] = "->��";
		P[3][2] = "->*FT'";
		P[3][4] = "->��";
		P[3][5] = "->��";
		P[4][0] = "->i";
		P[4][3] = "->(E)";
		
		// ��ӡ��Ԥ�������
		txt_1.append("                        �ѹ����õ�Ԥ�������"+"\r\n");
		txt_1.append("----------------------------------------------------------------------"+"\r\n             ");
		for (int i=0; i<6; i++) {
			txt_1.append("       "+Vt[i]+"       ");
		}
		txt_1.append("\r\n");
		txt_1.append("----------------------------------------------------------------------"+"\r\n");
		for (int i=0; i<5; i++) {
			txt_1.append("       "+Vn[i]+"       ");
			for (int j=0; j<6; j++) {
				int l = 0;
				if (j>0) {
					l = 10-P[i][j-1].length();
				}
				for (int k=0; k<l; k++) {
					txt_1.append(" ");
				}
				txt_1.append(P[i][j]+" ");
			}
			txt_1.append("\r\n");
		}
		txt_1.append("----------------------------------------------------------------------");
		
	}
	public void setCount(int count, int count1, int count2, int count3){
		this.count = count; 
		this.count1 = count1;
		this.count2 = count2;
		this.count3 = count3;
		flag = false;
	}
	public void setFenxi() { // ��ʼ������ջ
		fenxi = new String[20];
		fenxi[0] = "#";
		fenxi[1] = "E";
	}
	public boolean judge(JTextArea txt_2) {
		String inputChar = inputString.substring(0, 1); // ��ǰ�����ַ�
		boolean flage = false;
		if (count1 >= 0) {
			for (int i=0; i<6; i++) {
				if (fenxi[count1].equals(Vt[i])) { // �жϷ���ջջ�����ַ��Ƿ�Ϊ�ս��
					flage = true;
	    				break;
				}
			}
		}
		if (flage) {// Ϊ�ս��ʱ
			if (fenxi[count1].equals(inputChar)) {
				if (fenxi[count1].equals("#")&&inputString.length()==1) { // ջ������Ϊ������־ʱ// System.out.println("���һ��");
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) { // �õ�����ջ���ȫ�����ݣ���ȥnull��
						if (fenxi[i] == null) {
							break;
						} 
						else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// �����ǰ����ջ����������ַ��������ò���ʽ��ƥ��
					txt_2.append("   " + count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					System.out.print(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append("����"+"\r\n");
					flag = true;
					return true;
				} 
				else {// ����ջջ�����Ų�Ϊ������־����ʱ
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) { // �õ�����ջ���ȫ�����ݣ���ȥnull��
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// �����ǰ����ջ����������ַ��������ò���ʽ��ƥ��
					txt_2.append("   "+count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append("\"" + inputChar + "\"" + "ƥ��"+"\r\n");
					// ��ջ�����ų�ջ��ջ��ָ���һ
					fenxi[count1] = null;
					count1 -= 1;
					if (inputString.length() > 1) { // ����ǰ�����ַ����ĳ��ȴ���1ʱ������ǰ�����ַ��������ַ����г�ȥ
						inputString = inputString.substring(1, inputString
								.length());
					} else { // ��ǰ���봮����Ϊ1ʱ
						inputChar = inputString;
					}
					// System.out.println(" "+count+" "+fenxizhan+"
					// "+inputString +" "+P[count3][count2]);
					// System.out.println(count + inputChar + "ƥ�� ");
					count++;
					judge(txt_2);
				}		
			}
			else { // �ж�������������Ƿ�һ��Ϊ������־
				txt_2.append("        ��������" + count + "��ʱ����"+"\r\n");
				flag = false;
				return false;
			}
		} 
		else {
			// ���ս��ʱ
			boolean fla = false; 
			for (int i=0; i<6; i++) { // ��ѯ��ǰ�������λ���ս������λ��
				if (inputChar.equals(Vt[i])) {
					fla = true;
					count2 = i;
					break;
				}
			}
			if(!fla){
				txt_2.append("        ��������" + count + "��ʱ����"+"\r\n");
				flag = false;
				return false;
			}
			for (int i=0; i<5; i++) { // ��ѯջ���ķ���λ�ڷ��ս������λ��
				if (fenxi[count1].equals(Vn[i])) {
					count3 = i;
					break;
				}
			}
			if (P[count3][count2] != "error") { // ջ���ķ��ս����������ս�����ڲ���ʽʱ
				String p = P[count3][count2];
				String s1 = p.substring(2, p.length()); // ��ȡ��Ӧ�Ĳ���ʽ
				if (s1.equals("��")) { // ����ʽ�Ƴ����š�ʱ
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) {
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// �����ǰ����ջ����������ַ��������ò���ʽ��ƥ��
					txt_2.append("   " + count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxi[count1] + P[count3][count2]+"\r\n");
					// ��ջ�����ų�ջ��ջ��ָ��ָ����һ��Ԫ��
					fenxi[count1] = null;
					count1 -= 1;
					count++;
					judge(txt_2);
				} 
				else{ // ����ʽ���Ƴ����š�ʱ
					int k = s1.length();
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) {
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// �����ǰ����ջ����������ַ��������ò���ʽ��ƥ��
					txt_2.append("   "+count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int o=0; o<farWay; o++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int o=0; o<farWay; o++) {
						txt_2.append(" ");
					}
					txt_2.append(inputString);
					farWay = 25 - inputString.length();
					for (int o=0; o<farWay; o++) {
						txt_2.append(" ");
					}
					txt_2.append(fenxi[count1] + P[count3][count2]+"\r\n");
					for (int i=1; i<=k; i++) { // ������ʽ�Ҳ��ĸ���������ջ
						String s2 = s1.substring(s1.length() - 1, s1.length());
						s1 = s1.substring(0, s1.length() - 1);
						if (s2.equals("'")) {
							s2 = s1.substring(s1.length() - 1, s1.length())+ s2;
							i++;
							s1 = s1.substring(0, s1.length() - 1);
						}
						fenxi[count1] = s2;
						if (i < k)
							count1++;
						// System.out.println("count1=" + count1);
					}
					// System.out.println(" "+count+" "+fenxizhan+"
					// "+inputString +" "+P[count3][count2]);
					count++;
					// System.out.println(count);
					judge(txt_2);
				}
			} else {
				txt_2.append("        ��������" + count + "��ʱ����"+"\r\n");
				flag = false;
				return false;
			}
		}
		return flag;
	}
}
