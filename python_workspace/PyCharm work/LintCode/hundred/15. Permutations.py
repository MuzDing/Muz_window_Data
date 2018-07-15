#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 15. Permutations.py
@time: 2018/7/15 0015 下午 10:44
"""

import itertools


def permute( nums):
    return list(itertools.permutations(nums, len(nums)))


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    print(permute([1,2,3]))
