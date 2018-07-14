package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LL {
	String Vn[] = { "E", "E'", "T", "T'", "F" }; // 非终结符集
	String Vt[] = { "i", "+", "*", "(", ")", "#" }; // 终结符集
	String P[][] = new String[5][6]; // 预测分析表
	String fenxi[] ; // 分析栈
	int count = 1; // 步骤
	int count1 = 1;//’分析栈指针
	int count2 = 0, count3 = 0;//预测分析表指针	
	String inputString = ""; // 输入的字符串
	boolean flag;
	
	public void setCount(int count, int count1, int count2, int count3){
		this.count = count; 
		this.count1 = count1;
		this.count2 = count2;
		this.count3 = count3;
		flag = false;
	}
	
	public void setFenxi() { // 初始化分析栈
		fenxi = new String[20];
		fenxi[0] = "#";
		fenxi[1] = "E";
	}

	public void setP() { // 初始化预测分析表
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				P[i][j] = "error";
			}
		}
		P[0][0] = "->TE'";
		P[0][3] = "->TE'";
		P[1][1] = "->+TE'";
		P[1][4] = "->ε";
		P[1][5] = "->ε";
		P[2][0] = "->FT'";
		P[2][3] = "->FT'";
		P[3][1] = "->ε";
		P[3][2] = "->*FT'";
		P[3][4] = "->ε";
		P[3][5] = "->ε";
		P[4][0] = "->i";
		P[4][3] = "->(E)";
		// 打印出预测分析表
		System.out.println("                        已构建好的预测分析表");
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
		String inputChar = inputString.substring(0, 1); // 当前输入字符
		boolean flage = false;
		if (count1 >= 0) {
			for (int i=0; i<6; i++) {
				if (fenxi[count1].equals(Vt[i])) { // 判断分析栈栈顶的字符是否为终结符
					flage = true;
	    				break;
				}
			}
		}
		if (flage) {// 为终结符时
			if (fenxi[count1].equals(inputChar)) {
				if (fenxi[count1].equals("#")&&inputString.length()==1) { // 栈顶符号为结束标志时// System.out.println("最后一个");
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) { // 拿到分析栈里的全部内容（滤去null）
						if (fenxi[i] == null) {
							break;
						} 
						else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// 输出当前分析栈情况，输入字符串，所用产生式或匹配
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
					System.out.println("接受");
					flag = true;
					return true;
				} 
				else {// 分析栈栈顶符号不为结束标志符号时
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) { // 拿到分析栈里的全部内容（滤去null）
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// 输出当前分析栈情况，输入字符串，所用产生式或匹配
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
					System.out.println("\"" + inputChar + "\"" + "匹配");
					// 将栈顶符号出栈，栈顶指针减一
					fenxi[count1] = null;
					count1 -= 1;
					if (inputString.length() > 1) { // 当当前输入字符串的长度大于1时，将当前输入字符从输入字符串中除去
						inputString = inputString.substring(1, inputString
								.length());
					} else { // 当前输入串长度为1时
						inputChar = inputString;
					}
					// System.out.println(" "+count+" "+fenxizhan+"
					// "+inputString +" "+P[count3][count2]);
					// System.out.println(count + inputChar + "匹配 ");
					count++;
					judge();
				}		
			}
			else { // 判断与与输入符号是否一样为结束标志
				System.out.println("        分析到第" + count + "步时出错！");
				flag = false;
				return false;
			}
		} 
		else {
			// 非终结符时
			boolean fla = false; 
			for (int i=0; i<6; i++) { // 查询当前输入符号位于终结符集的位置
				if (inputChar.equals(Vt[i])) {
					fla = true;
					count2 = i;
					break;
				}
			}
			if(!fla){
				System.out.println("        分析到第" + count + "步时出错！");
				flag = false;
				return false;
			}
			for (int i=0; i<5; i++) { // 查询栈顶的符号位于非终结符集的位置
				if (fenxi[count1].equals(Vn[i])) {
					count3 = i;
					break;
				}
			}
			if (P[count3][count2] != "error") { // 栈顶的非终结符与输入的终结符存在产生式时
				String p = P[count3][count2];
				String s1 = p.substring(2, p.length()); // 获取对应的产生式
				if (s1.equals("ε")) { // 产生式推出“ε”时
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) {
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// 输出当前分析栈情况，输入字符串，所用产生式或匹配
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
					// 将栈顶符号出栈，栈顶指针指向下一个元素
					fenxi[count1] = null;
					count1 -= 1;
					count++;
					judge();
				} 
				else{ // 产生式不推出“ε”时
					int k = s1.length();
					String fenxizhan = "";
					for (int i=0; i<=P.length; i++) {
						if (fenxi[i] == null) {
							break;
						} else {
							fenxizhan = fenxizhan + fenxi[i];
						}
					}
					// 输出当前分析栈情况，输入字符串，所用产生式或匹配
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
					for (int i=1; i<=k; i++) { // 将产生式右部的各个符号入栈
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
				System.out.println("        分析到第" + count + "步时出错！");
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
				System.out.print("请输入字符串：");
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
				System.out.println("分析过程");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("   步骤    |       分析栈         |       剩余输入串         |       所用产生式   ");
				System.out.println("----------------------------------------------------------------------");
				boolean b = l.judge();
				System.out.println("----------------------------------------------------------------------");
				if(b){
					System.out.println("您输入的字符串"+input+"是LL1文法");
				}else{
					System.out.println("您输入的字符串"+input+"有词法错误！");
				}
			}			
		}
	}
}
