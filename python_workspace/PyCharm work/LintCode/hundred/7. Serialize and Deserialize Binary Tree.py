#!/usr/bin/env python
# encoding: utf-8


"""
@version: Python3
@author: Muz
@contact: ld56888@163.com
@site: http://www.xxxxx.com
@software: PyCharm
@file: 7. Serialize and Deserialize Binary Tree.py
@time: 2018/7/15 0015 下午 3:24
"""
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque
class Solution:
    def Serialize(self, root):
        u"把对象转换为字节序列的过程称为对象的序列化"

        # write code here
        def Pre_Order(root):
            if root:
                result.append(str(root.val))
                Pre_Order(root.left)
                Pre_Order(root.right)
            else:
                result.append("#")

        result = []
        Pre_Order(root)
        return ",".join(result)

    def Deserialize(self, s):
        u"把字节序列恢复为对象的过程称为对象的反序列化"
        # write code here
        s = s.split(",")

        def Change(num):
            num[0] += 1
            if num[0] < len(s):
                if s[num[0]] == "#":
                    return None
                root = TreeNode(int(s[num[0]]))
                root.left = Change(num)
                # 传递的num是列表而不是一个变量，如果是变量的话在上面的这条语句执行完以后num并没有记录上一步执行时的加1
                root.right = Change(num)
                return root
            else:
                return None

        num = [-1]
        return Change(num)