// jiami26.cpp : 定义控制台应用程序的入口点。
//


#include <stdio.h>
#include <stdafx.h>
#include <string.h>

void main()
{
	int i=0,n;
	char str[20],c;
	printf("请输入一个字符串：\n");
	gets(str);
	puts(str);
	for (i=0; i < strlen(str); i++)
	{
		str[i] = str[i] + 26;
		str[i] = (int)str[i] % 10;
		printf("%d", str[i]);
	}
	
	getchar();
}

