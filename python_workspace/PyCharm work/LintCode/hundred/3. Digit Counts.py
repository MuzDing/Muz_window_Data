#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.phpgao.com
@software: PyCharm
@file: 3. Digit Counts.py
@time: 2018/7/8 0008 下午 11:26
"""


def func(k,n):
    result = 0
    for i in range(n+1):
        result = result + str(i).count(str(k))
    print(result)

class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    func(0,19)
