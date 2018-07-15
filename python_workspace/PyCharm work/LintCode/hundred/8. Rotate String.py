#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 8. Rotate String.py
@time: 2018/7/15 0015 下午 6:28
"""


def func(s, offset):
    tempstr = s[offset + 1:len(s)] + s[0:len(s) - offset]
    return s[offset+1:len(s)]+s[0:len(s)-offset]


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    print(func("abcdefg",3))
