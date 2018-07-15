#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 4. Ugly Number II.py
@time: 2018/7/14 0014 下午 11:36
"""
import heapq
pool = set()
seq = []
hpq = [1]
def func(n):
    while len(seq) < n :
        i = heapq.heappop(hpq)
        print(i)
        seq.append(i)
        for j in (i * 2,i * 3, i * 5):
            if j not  in pool:
                pool.add(j)
                heapq.heappush(hpq ,j)
    else:
        print(seq[n-1])


class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    func(9)
