package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LL {
	String Vn[] = { "E", "E'", "T", "T'", "F" }; // ���ս����
	String Vt[] = { "i", "+", "*", "(", ")", "#" }; // �ս����
	String P[][] = new String[5][6]; // Ԥ�������
	String fenxi[] ; // ����ջ
	int count = 1; // ����
	int count1 = 1;//������ջָ��
	int count2 = 0, count3 = 0;//Ԥ�������ָ��	
	String inputString = ""; // ������ַ���
	boolean flag;
	
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

	public void setP() { // ��ʼ��Ԥ�������
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
		System.out.println("                        �ѹ����õ�Ԥ�������");
		System.out.println("----------------------------------------------------------------------");
		for (int i=0; i<6; i++) {
			System.out.print("          "+Vt[i]);
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		for (int i=0; i<5; i++) {
			System.out.print("   "+Vn[i]+"    ");
			for (int j=0; j<6; j++) {
				int l = 0;
				if (j>0) {
					l = 10-P[i][j-1].length();
				}
				for (int k=0; k<l; k++) {
					System.out.print(" ");
				}
				System.out.print(P[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------------------");
	}

	public void setInputString(String input) {
		inputString = input;
	}
	
	public boolean judge() {
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
					System.out.print("   " + count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.println("����");
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
					System.out.print("   "+count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.println("\"" + inputChar + "\"" + "ƥ��");
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
					judge();
				}		
			}
			else { // �ж�������������Ƿ�һ��Ϊ������־
				System.out.println("        ��������" + count + "��ʱ����");
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
				System.out.println("        ��������" + count + "��ʱ����");
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
					System.out.print("   " + count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.print(inputString);
					farWay = 25 - inputString.length();
					for (int k=0; k<farWay; k++) {
						System.out.print(" ");
					}
					System.out.println(fenxi[count1] + P[count3][count2]);
					// ��ջ�����ų�ջ��ջ��ָ��ָ����һ��Ԫ��
					fenxi[count1] = null;
					count1 -= 1;
					count++;
					judge();
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
					System.out.print("   "+count);
					String countToString = Integer.toString(count);
					int farWay = 14 - countToString.length();
					for (int o=0; o<farWay; o++) {
						System.out.print(" ");
					}
					System.out.print(fenxizhan);
					farWay = 20 - fenxizhan.length();
					for (int o=0; o<farWay; o++) {
						System.out.print(" ");
					}
					System.out.print(inputString);
					farWay = 25 - inputString.length();
					for (int o=0; o<farWay; o++) {
						System.out.print(" ");
					}
					System.out.println(fenxi[count1] + P[count3][count2]);
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
					judge();
				}
			} else {
				System.out.println("        ��������" + count + "��ʱ����");
				flag = false;
				return false;
			}
		}
		return flag;
	}

	public static void main(String args[]) {
		LL l = new LL();	
		l.setP();
		String input = "";
		boolean flag = true;
		while (flag) {
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				System.out.println();
				System.out.print("�������ַ�����");
				input = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(input.equals("exit")){
				flag = false;
			}else{
				l.setInputString(input);
				l.setCount(1, 1, 0, 0);
				l.setFenxi();
				System.out.println();
				System.out.println("��������");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("   ����    |       ����ջ         |       ʣ�����봮         |       ���ò���ʽ   ");
				System.out.println("----------------------------------------------------------------------");
				boolean b = l.judge();
				System.out.println("----------------------------------------------------------------------");
				if(b){
					System.out.println("��������ַ���"+input+"��LL1�ķ�");
				}else{
					System.out.println("��������ַ���"+input+"�дʷ�����");
				}
			}			
		}
	}
}
