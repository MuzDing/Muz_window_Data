#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 9. Fizz Buzz.py
@time: 2018/7/15 0015 下午 6:58
"""


def func(n):
    liststr = []
    for i in range(1,16):
        if i % 3 == 0 and i % 5 == 0:
            liststr.append("fizz buzz")

        elif i % 5 == 0:
            liststr.append("buzz")
        elif i % 3 == 0:
            liststr.append("fizz")
        else:
            liststr.append(str(i))
    return liststr
class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    func(15)
