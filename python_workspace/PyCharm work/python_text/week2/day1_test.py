# -*- coding:utf-8 -*-  
__author__ = 'Muz'
__date__ = '10/11/2017 4:48 PM'

# import sys
# print(sys.argv)
# print(sys.path) #环境变量

import os

# cmd=os.popen("ll").read()
# print(cmd)

# #创建目录
#os.mkdir("asd")

# #列表切片
# name=['a','b','c']
# print(name[1:3])
# print(name[-2:])
# #name.insert(1,"d")
# print(name)
# #print(name.pop(1))
#
# #列表反转
# name.reverse()
# print(name.reverse())
#
# import copy
#
# #完全复制
# na=['1','2']
# na2=copy.deepcopy(na)
#
# #浅copy
# p1=copy.copy(na)
# p2=na[:]
# p3=list(na)

# name = 'li\tding{name},{id}'
# print(name.capitalize())        #首字母大写
# print(name.count('i'))      #统计个数
# print(name.center(50,'-'))      #50个字符 不够用’-‘ 字符串放中间
# print(name.endswith('g'))       #判断结尾
# print(name.expandtabs(tabsize=20))      #N个空格
# print(name.find('n'))
# print(name.format(name='1',id='2'))
# print(name.format_map({'name':'i','id':'1111'}))
# print("123sad".isalnum())
# print("sad".isalpha())
# print('as'.isidentifier())      #判断是不是一个合法的标识符
# print('123'.isnumeric())      #判断是不是只有数字
# print('1213'.isdecimal())       #判断是不是十进制
#
# print("12312".join("=="))
#
# print('\nasd\n'.strip())
#
# p=str.maketrans("abc","123")
# print('abc123'.translate(p))
# print("aaabbbxxx".replace('a','32',2))
# print("a+c+b".split('+'))

info = {'s1':'123','s2':'321'}
info1 = {1:1,2:2}
print(info)
#del info['s1']
print(info)
#info.popitem()#随机删除

print(info.get('s1'))
print('s1' in info)

#info.update(info1)      #合并

print(info.items())  #转列表
print(info.values())        #值
print(info.keys())      #键
print(dict.fromkeys(['s1','s2']))
print(dict.fromkeys(['s1','s2'],[1,2,3]))

for i in info:
    print(i,info[i])
for i,j in info.items():
    print(i,j)
