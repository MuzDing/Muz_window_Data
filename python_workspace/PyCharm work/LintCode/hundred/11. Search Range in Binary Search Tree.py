#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 11. Search Range in Binary Search Tree.py
@time: 2018/7/15 0015 下午 7:09
"""
def func():
    pass

def searchRange(self, root, k1, k2):
    # write your code here
    ans = []
    if root is None:
        return ans
    queue = [root]
    index = 0
    while index < len(queue):
        if queue[index] is not None:
            if queue[index].val >= k1 and \
                            queue[index].val <= k2:
                ans.append(queue[index].val)

            queue.append(queue[index].left)
            queue.append(queue[index].right)

        index += 1
    return sorted(ans)

class Main():
    def __init__(self):
        pass


if __name__ == '__main__':
    func()
