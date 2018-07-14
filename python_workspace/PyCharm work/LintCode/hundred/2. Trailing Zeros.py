class Solution:
    """
    @param: n: An integer
    @return: An integer, denote the number of trailing zeros in n!
    """
    def trailingZeros(self, n):
        # write your code here, try to do it without arithmetic operators.
        ret = 0
        while (n):
            n = int(n / 5)
            ret = ret + n
        return ret
        # result = 1
        # zeros=0
        # for i in range(1, n+1):
        #     result = result *i
        #     if str(result)[-1] == '0':
        #         zeros = zeros + 1
        #         result= int(str(result)[0:-1])
        # return zeros
if __name__ == '__main__':
    s = Solution()
    print(s.trailingZeros(105))