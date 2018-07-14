# -*- coding:utf-8 -*-  
__author__ = 'Muz'
__date__ = '10/12/2017 11:49 AM'

# list_1 = {1,2,3,4,5,5,5}
# list_2 = set([1,2,3,6,6,6])
#
# print(list_1,list_2)
# #交集
# print(list_1.intersection(list_2))
# print(list_2 & list_1)
# #并集
# print(list_1.union(list_2))
# print(list_1 | list_2)
# #差集
# print(list_1.difference(list_2))
# print(list_1-list_2)
# #父集
# print(list_1.issuperset({1,2}))
# #子集
# print({1,2}.issubset(list_1))
# #对称差集
# print(list_1.symmetric_difference(list_2))
# print(list_1 ^ list_2)
#
# #添加
# list_1.add(0)
# print(list_1)
# #删除
# list_1.discard(90)  #remove
# print(list_1)


# data = open('qwe.txt','rt',encoding="utf")
# print(data.read())

# data = open('qwe.txt','r',encoding='utf-8')
# #查看句柄
# print(data.tell())
# #移动光标
# print(data.seek(0))
# #读文件的接口
# print(data.fileno())
#
# #读文件
# # for i in data.readlines():
# #     print(i.strip())
# # for index,line in enumerate(data.readlines()):
# #     print(index,line.strip())
# for line in data:
#     print(line.strip())


# #进度条
# import sys,time
# for i in range(20):
#     sys.stdout.write("*")
#     sys.stdout.flush()
#     time.sleep(0.1)


# #参数
# def test(x,y,*args,**kwargs):
#     print(x)
#     print(y)
#     print(args)
#     print(kwargs)
# x = 1
# y = 2
# test(1,2,3,4,5,name='liding')

# # 高阶函数
# def add(x,y,f):
#     return f(x)+f(y)
#
# print(add(1,2,abs))