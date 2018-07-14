package ex;

public class MainTest {
	public static void main(String[] args) {
		/*鍒涘缓璇嶆硶鍒嗘瀽绫�*/
		TestLexer testLexer = new TestLexer("./src/input.txt");
		//FileUtil.clearFile();//娓呯┖鏂囦欢
		testLexer.analyse();
	}
}