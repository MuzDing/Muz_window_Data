package testteaml;

import java.util.Scanner;

public class ll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner input = new Scanner(System.in);
	    int a = input.nextInt();
	    int b=  input.nextInt();
		
		String a1=String.valueOf(a);
		String b1=String.valueOf(b);
		
		int count=0;
		if(a>=1 && a<=1000000000 &&b>=a &&b<=1000000000) {
			for(int i=0;i<b-a;i++) {
				String temp=String.valueOf(i);
				int n=0;
				for(int j=0 ;j<temp.length();j++) {
					if(temp.charAt(j)=='6' || temp.charAt(j)=='8') {
						n++;
					}
				}
				if(n==temp.length()) {
					count++;
				}
				
			}
			System.out.println(count);
		}
		
	}

}
