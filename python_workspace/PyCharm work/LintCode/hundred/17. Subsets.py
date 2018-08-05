#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 17. Subsets.py
@time: 2018/8/5 0005 下午 9:39
"""

'''
[1] [2] [3] [4]
[1,2] [2,3] [3,4] [4,1]
[1,2,3] [2,3,4] [3,4,1] [4,1,2]
[1,2,3,4]
[]
3*4+1+1 = 14
4*4-1 = 15
2=4  
3*2+2 =8
4*3+2 = 16
'''
# n * (n - 1) + 2
results = []
def search(nums, S, index):
    if index == len(nums):
        results.append(S)
        return
    search(nums, S + [nums[index]], index + 1)
    search(nums, S, index + 1)

def subsets( nums):
    search(sorted(nums), [], 0)
    return results
if __name__ == '__main__':
    m_list  = [1, 2]
    print(subsets(m_list))


