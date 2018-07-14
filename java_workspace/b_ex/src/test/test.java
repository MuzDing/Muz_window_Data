package test;

public class test {
	
	private String[] code = new String[36];
	private String Code="1403";
	public test(){
	code[0]=".----";
	code[1]="..---";
	code[2]="...--";
	code[3]="....-";
	code[4]=".....";
	code[5]="-....";
	code[6]="--...";
	code[7]="---..";
	code[8]="----.";
	code[9]="-----";
	
	code[10]="10";
	code[11]="0111";
	code[12]="0101";
	code[13]="011";
	code[14]="1";
	code[15]="1101";
	code[16]="001";
	
	code[17]="1111";
	code[18]="11";
	code[19]="1000";
	code[20]="010";
	code[21]="1011";
	code[22]="00";
	code[23]="01";
	
	code[24]="000";
	code[25]="1001";
	code[26]="0010";
	code[27]="101";
	code[28]="111";
	code[29]="0";
	code[30]="110";
	code[31]="1110";
	code[32]="100";
	code[33]="0110";
	code[34]="0100";
	code[35]="0011";

	}
//10O011O00O11O01O
	public void jiam(){
		String co="";
		char ch='a';
		Code.toLowerCase();
		for(int i=0;i<Code.length();i++){//通过length方法获取字符串长度
		    ch=Code.charAt(i);
		    System.out.println(ch);
		    switch (ch) {
		    case '0': co=co+code[0]+"O"; break;
		    case '1': co=co+code[1]+"O"; break;
		    case '2': co=co+code[2]+"O"; break;
		    case '3': co=co+code[3]+"O"; break;
		    case '4': co=co+code[4]+"O"; break;
		    case '5': co=co+code[5]+"O"; break;
		    case '6': co=co+code[6]+"O"; break;
		    case '7': co=co+code[7]+"O"; break;
		    case '8': co=co+code[8]+"O"; break;
		    case '9': co=co+code[9]+"O"; break;
		    
			case 'a': co=co+code[10]+"O"; break;
			case 'b': co=co+code[11]+"O"; break;
			case 'c': co=co+code[12]+"O"; break;
			case 'd': co=co+code[13]+"O"; break;
			case 'e': co=co+code[14]+"O"; break;
			case 'f': co=co+code[15]+"O"; break;
			case 'g': co=co+code[16]+"O"; break;
			case 'h': co=co+code[17]+"O"; break;
			case 'i': co=co+code[18]+"O"; break;
			case 'j': co=co+code[19]+"O"; break;
			case 'k': co=co+code[20]+"O"; break;
			case 'l': co=co+code[21]+"O"; break;
			case 'm': co=co+code[22]+"O"; break;
			case 'n': co=co+code[23]+"O"; break;
			case 'o': co=co+code[24]+"O"; break;
			case 'p': co=co+code[25]+"O"; break;
			case 'q': co=co+code[26]+"O"; break;
			case 'r': co=co+code[27]+"O"; break;
			case 's': co=co+code[28]+"O"; break;
			case 't': co=co+code[29]+"O"; break;
			case 'u': co=co+code[30]+"O"; break;
			case 'v': co=co+code[31]+"O"; break;
			case 'w': co=co+code[32]+"O"; break;
			case 'x': co=co+code[33]+"O"; break;
			case 'y': co=co+code[34]+"O"; break;
			case 'z': co=co+code[35]+"O"; break;
			default:
				break;
			}
		}   	

			
		
		System.out.println(co);
		System.out.println("xxxxxxxxxxxxxxxx");
		
	}
	
}

