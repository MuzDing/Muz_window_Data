#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 12. Min Stack.py
@time: 2018/7/15 0015 下午 7:12
"""


def func():
    list1 = [1, 2, 3]
    list1.remove(len(list1))
    print(list1)


class Main():
    def __init__(self):
        self.listnumber = []

    def push(self, number):
        self.listnumber.append(number)

    """
    @return: An integer
    """

    def pop(self):

        temp = self.listnumber.pop()

        return temp

    """
    @return: An integer
    """

    def min(self):
        return min(self.listnumber)


if __name__ == '__main__':
    # func()
    m = Main()
    m.push(1)
    print(m.pop())
    m.push(2)
    m.push(3)
    print(m.min())
    m.push(1)
    print(m.min())