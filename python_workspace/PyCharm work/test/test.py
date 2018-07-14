# -*- coding:utf-8 -*-  
__author__ = 'Muz'
__date__ = '11/10/2017 7:05 PM'

import random

def isUnique(str):
    a = list(str)
    n = len(a)
    for i in range(n):
        if str.count(a[i]) != 1:
            print(str)
            return
    return
def fun():
    print(random.randint(0,10))
if __name__ =="__main__":

    fun()
    # for i in range(len(m_list)):
    #     isUnique(m_list[i])
