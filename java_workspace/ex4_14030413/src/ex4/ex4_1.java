package ex4;
import java.io.*;
public class ex4_1 {
	public static void main(String arg[])
	{
		int lenght;
		byte buf[]=new byte[1024];
		try{
			FileInputStream in;
			FileOutputStream out;
			in = new FileInputStream("d:\\111.txt");
			out = new FileOutputStream("d:\\123.txt");
			while((lenght = in.read(buf,0,1024))!=-1)
			{
				out.write(buf,0,lenght);
			}
		
		}catch(IOException e)
			{
				System.out.println("error:" + e);
				System.exit(-1);
			}
		File file = new File("d:\\111.txt");
		System.out.println("文件长度："+file.length());
		System.out.println("文件名："+file.getName());
	}

}


