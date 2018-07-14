package com.test;

import java.io.File;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) {
		File f = new File("D:\\abcd\\a\\b");
		if(!f.exists()){
			f.mkdirs();
		}
		
		File f2 = new File("D:\\abcd\\a.txt");
		if(!f2.exists()){
			try {
				f2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
