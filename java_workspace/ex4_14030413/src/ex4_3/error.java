package ex4_3;

import javax.swing.JOptionPane;

public class error {
	public static void main(String arg[])
	{
	
	}
	public error(int i) {
		// TODO 自动生成的构造函数存根
		if(i<0 || i>120)
		{
			JOptionPane.showMessageDialog(null, "年龄应大于0小于120", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		if(i/1000000000 == 0)
		{
			JOptionPane.showMessageDialog(null, "手机号必须11位", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
		if(i/1000000000 == 0)
		{
			JOptionPane.showMessageDialog(null, "手机号必须11位", "提示", JOptionPane.ERROR_MESSAGE); 
			return;
		}
	}
}
