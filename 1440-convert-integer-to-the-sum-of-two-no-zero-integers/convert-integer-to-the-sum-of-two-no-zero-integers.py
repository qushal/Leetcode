class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:

        def check(a):
            for i in str(a):
                if i == '0':
                    return False
            return True

        ans = []
        for a in range(1, n):
            b = n-a
            state1 = check(a)
            state2 = check(b)
            
            if state1 and state2:
                ans.append(a)
                ans.append(b)
                break
           
        return ans 