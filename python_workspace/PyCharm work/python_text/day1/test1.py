# -*- coding:utf-8 -*-  
__author__ = 'Muz'
__date__ = '10/11/2017 4:02 PM'


# name = "李丁"
# iid="14030413"
# info1='''
# name:%s
# id:%s
# '''%(name,iid)

# name = "李丁"
# iid = "14030413"
# info1 = '''
# name={name}
# id={iid}
# ''' .format(name=name, iid=iid)


# name = "李丁"
# iid = "14030413"
# info1 = '''
# name:{0}
# id:{1}
# ''' .format(name,iid)
# print(info1)


#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import getpass

#pwd = getpass.getpass("psw:")   #命令行使用
#print(pwd)

# count=0
# while count<4:
#     count=count+1
#     if int(input()) ==2:
#         break
#     if count == 3 :
#         if (input("是否要继续进行 y/n：").__eq__("n")):
#             print("good game")
#
# else:
#     print("陈逸")


for i in range(10):
    if i < 5:
        print("loo[",i)