package test;

public class test1 {
	private String[] code = new String[36];
	private String Code = "..---O.....O.----O....-O";
	public test1(){
	
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
	public void jiem(){
		
		String co="";
		String cod="";
		
		char ch;
		
		for(int i=0;i<Code.length();i++){
			ch=Code.charAt(i);
			if(ch != 'O'){
				co=co+ch;
			}
			if(ch == 'O')
			{
				for(int j = 0 ;j<code.length ;j++)
				{
					if(co.equals(code[j])){
						if(j<10)
							cod=cod+j;
						else{
							switch (j) {
							case 10: cod+="a"; break;
							case 11: cod+='b'; break;
							case 12: cod+='c'; break;
							case 13: cod+="d"; break;
							case 14: cod+='e'; break;
							case 15: cod+='f'; break;
							case 16: cod+='g'; break;
							case 17: cod+='h'; break;
							case 18: cod+="i"; break;
							case 19: cod+='j'; break;
							case 20: cod+='k'; break;
							case 21: cod+='l'; break;
							case 22: cod+="m"; break;
							case 23: cod+="n"; break;
							case 24: cod+='o'; break;
							case 25: cod+='p'; break;
							case 26: cod+='q'; break;
							case 27: cod+='r'; break;
							case 28: cod+='s'; break;
							case 29: cod+='t'; break;
							case 30: cod+='u'; break;
							case 31: cod+='v'; break;
							case 32: cod+='w'; break;
							case 33: cod+='x'; break;
							case 34: cod+='y'; break;
							case 35: cod+='z'; break;
							default:
								break;
							}
						}
					}
					
					}
				co="";
				}
				
			}
			System.out.println(cod);
	}

}
