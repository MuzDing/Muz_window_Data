// ConsoleApplication2.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>

int _tmain(int argc, _TCHAR* argv[])
{
	int size = 8 * 1024 * 1024 * 1024L;
	char* a = new char(size);
	*(a + 1) = 'a';
	getchar();
	return 0;
}

