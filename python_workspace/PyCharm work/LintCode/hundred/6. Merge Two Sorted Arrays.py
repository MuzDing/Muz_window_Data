#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 6. Merge Two Sorted Arrays.py
@time: 2018/7/15 0015 下午 2:18
"""


def func():
    list1 = [1, 2, 9, 10, 14, 16]
    list2 = [2, 3, 4, 5]
    list3 = []
    i = 0
    j = 0
    while(i < len(list1) and  j < len(list2)):
        if(list1[i] < list2[j]):
            list3.append(list1[i])
            i += 1
        else:
            list3.append(list2[j])
            j += 1
    else:
        while i < len(list1):
            list3.append(list1[i])
            i += 1
        while j < len(list2):
            list3.append(list[j])
            j += 1
    print(list3)


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    func()
