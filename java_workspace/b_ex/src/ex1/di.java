package ex1;

import java.util.Scanner;

public class di {
	public char[] s;
	public int x=0,i=0;
	public void init(){
	System.out.printf("请输入算数表达式：");
	Scanner str = new Scanner(System.in);
	String s1 = null;
	s1 = str.next();
	s=new char[50];

	for(int temp=0;temp<s1.length();temp++)
	{
		s[temp]=s1.charAt(temp);
	}
	System.out.println("代分析     产生式     剩余  ");
	E();
	if(s[i]!='#' || x==1)
	{
		System.out.println("error\n");
		return ;
	}	
	}
	public void output1(int i)
	{
		for(int j=0;j<=i;j++)
		{
			System.out.print(s[j]);
		}
		System.out.printf("\t");
	}
	public void output(int i)
	{
		for(;i<s.length;i++)
		{	
			System.out.printf("%c",s[i]);
		}
		System.out.printf("\n");
	}
	public void advance()
	{
		i++;
	}
	public void E()     //E->TE'
	{
		if(x==0)
		{
			output1(i);
			System.out.printf("E->TE1\t");
			output(i+1);
			T();
			E1();
		}
	}
	public void E1()    //E->+TE'|-TE'|^
	{
		if(x==0)
		{
			if(s[i]=='+')
			{
				output1(i);
				System.out.printf("E1->+TE1\t");
				output(i+1);
				advance();
				T();
				E1();
			}
			else if(s[i]=='-')
			{
				output1(i);
				System.out.printf("E1->-TE1\t");
				output(i+1);
				advance();
				T();
				E1();
			}
			else if(s[i]=='#')
			{
				output1(i-1);
				System.out.printf("E1->ε\t");
				output(i);
			}
			else
			{
				output1(i);
				System.out.printf("E1->ε\t");
				output(i+1);
			}
		}
	}
	/*T()函数*/
	public void T()     //FT'
	{
	    if(x==0)
		{
			if(s[i]!='#')
			{
				output1(i);
				System.out.printf("T->FT1\t");
				output(i+1);
				F();
				T1();
			}
		
			else
			{
				output1(i-1);
				System.out.printf("T->FT1\t");
				output(i);
				F();
				T1();
			}
		}
	}
	/*T1()函数*/
	public void T1()          // T'=*FT'|/FT'|^
	{
		if(x==0)
		{
			if(s[i]=='*')      
			{
				output1(i);
				System.out.printf("T1->*FT1\t");
				output(i+1);
				advance();
				F();
				T1();
			}
			else if(s[i]=='/')
			{
				output1(i);
				System.out.printf("T1->/FT1\t");
				output(i+1);
				advance();
				T1();
				F();
			}
			else if(s[i]=='#')
			{
				output1(i-1);
				System.out.printf("T1->ε\t");
				output(i);
			}
			else
			{
				output1(i);
				System.out.printf("T1->ε\t");
				output(i+1);
			}
		}
	}
	/*F()函数*/
	public void F()    //	F->i|(E)
	{
		if(x==0)
		{
			if(s[i]=='i')
			{
				output1(i);
				System.out.printf("F->i\t");
				output(i+1);
				advance();
			}
			else if(s[i]=='(')
				{
					output1(i);
					System.out.printf("F->(E)\t");
					output(i+1);
					advance();
					E();
					if(x!=1)
					{
					if(s[i]==')')
					{
						output1(i);
						System.out.printf("F->(E)\t");
						output(i+1);
						advance();
					}
					else
					{
						x=1;
					
					}}
				}
			
			
		 else if(s[i]=='#')
			{
					x=1;				
			}
		 else if(s[i]==')')
			 x=1;
		}
	}
}
