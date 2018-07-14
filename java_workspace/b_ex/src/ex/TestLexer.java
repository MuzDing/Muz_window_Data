package ex;
/**
 * 词法分析
 * 关键字，运算符一符一类  
 * 标识符，常数，分隔符各自一类
 * 运算符未处理组合运算 ++、--、+= 等
 * @author zhangyu
 * @version 3.0
 */
public class TestLexer extends TypeUtil{
	private StringBuffer buffer = new StringBuffer(); // 缓冲区
	private int i = 0;
	private char ch; // 字符变量，存放最新读进的源程序字符
	private String strToken; // 字符数组，存放构成单词符号的字符串
	
	private static int lenght = 0;
	private static int lenght1 = 0;
	private final String keyWords[] = { "begin", "do", "else", "end",
			"if", "then", "var", "while" }; // 关键字数组
	private final char operators[] = { '+', '-', '*', '/','>','<','='}; // 运算符数组
	private final char separators[] = { ',', '(' , ')' , ':' , '.' , ';'}; // 界符数组

	private final String keyWords1[] = { "1,1", "1,2", "1,3", "1,4",
			"1,5", "1,6", "1,7", "1,8" };
	private String[] iD = new String[20];
	private String[] dight = new String[20];
	public TestLexer() {
	}
	/**
	 * 读取指定路径文件
	 * @param fileSrc 读取文件路径
	 */
	public TestLexer(String fileSrc) {
		FileUtil.readFile(buffer, fileSrc);
	}

	/**
	 * 词法分析
	 */
	public void analyse() {
		strToken = ""; // 置strToken为空串
		FileUtil.clearFile();//清空文件
		while (i < buffer.length()) {
			getChar();
			getBC();
			if (isLetter(ch)) { // 如果ch为字母
				while (isLetter(ch) || isDigit(ch)) {
					concat();
					getChar();
				}
				retract(); // 回调
				if (isKeyWord(strToken)) {
					int i=0;
					for(i=0;i<keyWords.length;i++)
					{
						
						if(strToken.equals(keyWords[i]))
						{
							break;
						}
					}
					writeFile(keyWords1[i],strToken);//strToken为关键字
				} else { 
					
					//iD[lenght++]=strToken;
					writeFile("6",strToken);//strToken为标识符
				}
				strToken = "";
			} else if (isDigit(ch)) { 
				while (isDigit(ch)) {//ch为数字
					concat();
					getChar();
				}
				if(!isLetter(ch)){//不能数字+字母
					retract(); // 回调
					dight[lenght++]=strToken;
					writeFile("5",strToken); // 是整形
				}else writeFile("error",strToken); // 非法
				strToken = "";
			} else if (isOperator(ch)) { //运算符
		
				//System.out.println(ch+"   "+(int)ch);
				switch (ch) {
				case '+': writeFile("3,10H",ch+""); break;
				case '-': writeFile("3,11H",ch+""); break;
				case '*': writeFile("3,20H",ch+""); break;
				case '/': writeFile("3,21H",ch+""); break;
	
				case '>': writeFile("4,03H",ch+""); break;
				case '<': writeFile("4,00H",ch+""); break;
				case '=': writeFile("4,02H",ch+""); break;
					default:  break;
				}
			} 
			else if (isSeparators(ch)) { 
				switch(ch){
					case ',': writeFile("2,0",ch+""); break;
					case '.': writeFile("2,2",ch+""); break;
					case '(': writeFile("2,4",ch+""); break;
					case ')': writeFile("2,5",ch+""); break;
					case ';': writeFile("2,1",ch+""); break;
					default:  break;
				}
			}
		}
	}

	/**
	 * 将下一个输入字符读到ch中，搜索指示器前移一个字符
	 */
	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}
	/** 检查ch中的字符是否为空白，若是则调用getChar()直至ch中进入一个非空白字符*/
	public void getBC() {
		//isSpaceChar(char ch) 确定指定字符是否为 Unicode 空白字符。
		//上述方法不能识别换行符
		while (Character.isWhitespace(ch))//确定指定字符依据 Java 标准是否为空白字符。
			getChar();
	}

	/**将ch连接到strToken之后*/
	public void concat() {
		strToken += ch;
	}
	/** 将搜索指示器回调一个字符位置，将ch值为空白字 */
	public void retract() {
		i--;
		ch = ' ';
	}
	/**
	 * 按照二元式规则写入文件
	 * @param file 字符类型
	 * @param s	当前字符
	 */
	public void writeFile(String file,String s) {
	//	int temp = getType(file.toUpperCase());
	//	System.out.println("("+file+", "+s+temp+")");
		file = "("+file+", "+s+")"+"\r\n";
		FileUtil.writeFile(file);
	}
}