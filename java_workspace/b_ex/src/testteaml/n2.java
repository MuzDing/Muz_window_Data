package testteaml;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,String> map = new HashMap<String, String>();
		Scanner input = new Scanner(System.in);
	    double m = input.nextDouble();
	    int n = input.nextInt();	    
	    double count=m;
	    int index=0;
	    int x=0;
		if(m>=1.0 && m<=1000.0 &&n>=1 &&n<=20) {
			DecimalFormat fnum = new DecimalFormat("##0.00");  
			for(int i=0 ; i< n-1;i++) {
				
				if(index==0) {
					boolean flag =true;
					while(flag) {
						double money=(double)(Math.random()*m+1);
						if(money < m) {
							flag=false;
							m=money;
						}
					}
				}
				else {
					boolean flag =true;
					while(flag) {
						double money=(double)(Math.random()*m+1);
						if(money < count) {
							flag=false;
							m=money;
						}
					}
				}
				
				String dd=fnum.format(m);      				
				map.put("a"+x++, dd);
				count=count-m;
				m=count;			
				index++;
			}
			String dd=fnum.format(m); 
			map.put("a"+x++, dd);
			
		}
		for(Map.Entry<String, String> entry :map.entrySet()) {
			System.out.println(entry.getKey() +"    "+  entry.getValue());
		}
	}

}
