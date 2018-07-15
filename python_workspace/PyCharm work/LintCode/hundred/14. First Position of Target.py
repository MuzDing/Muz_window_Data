#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 14. First Position of Target.py
@time: 2018/7/15 0015 下午 10:02
"""


def binarySearch(nums, target):
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = int((low + high) / 2)
        if nums[mid] == target:
            while nums[mid] == nums[mid - 1]:
                mid -= 1
            else:
                return mid
        elif nums[mid] > target:
            high = mid - 1
        else:
            low = mid + 1
    return -1  # null证明没有找到


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    binarySearch([1,4,4,5,7,7,8,9,9,10],1)
