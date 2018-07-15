#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 16. Permutations II.py
@time: 2018/7/15 0015 下午 11:01
"""

import itertools


def permute( nums):
    return itertools.permutations(nums, len(nums))


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    print(set(list(permute([1, 2, 2]))))
