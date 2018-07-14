package ex;

/**
 * 种别编码 为助记符指定int型编码
 * @author zhangyu<br/>
 *  <b><界符(分隔符)未单独定义></b><br/>
 *  如 : , ;  {  }  (  )	 [  ]  _  :  .  "等
 *  统一归为 SEPARATORS = 61; //界符类
 */
public class KeyTypes {
	
	/** 运算符*/
	public static final int PULS = 31;//加
	public static final int MIX = 32;//减
	public static final int MUL = 33;//乘
	public static final int DIV = 34;//除
	
	public static final int DOU = 20;//,
	public static final int DIANDOU = 21;//;
	public static final int DIAN = 22;//.
	public static final int ZKUO = 24;//(
	public static final int YKUO = 25;//)
	
	
	public static final int DY = 43;//等于
	public static final int XY = 41;//小于
	public static final int DAY = 44;//大于
	
	/** 界符{ ',', ';', '{', '}', '(', ')', '[', ']', '_', ':', '.', '"' };*/
	
	/**标识符*/
	public static final int ID = 6;
	
	/** 非法字符*/
	public static final int ERROR = -1;
	
	/** 常数*/
	public static final int DIGIT = 5;
	
	/**关键字对应*/
	public static final int BEGIN = 10;
	public static final int DO = 11;
	public static final int ELSE = 12;
	public static final int IF = 14;
	public static final int THEN = 15;
	public static final int VAR = 16;
	public static final int WHILE = 17;
	public static final int END = 13;
}