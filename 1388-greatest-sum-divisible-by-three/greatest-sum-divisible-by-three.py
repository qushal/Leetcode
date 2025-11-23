class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        remain1 = []
        remain2 = []
        total = 0
        for num in nums:
            total += num
            if num % 3 == 1:
                remain1.append(num)
            if num % 3 == 2:
                remain2.append(num)
        
        if total % 3 == 0:
            return total
        remain1.sort()
        remain2.sort()

        remainder = total % 3
        result = 0 

        if remainder == 1:
            remove1 = remain1[0] if len(remain1) > 0 else float('inf')
            remove2 = remain2[0] + remain2[1] if len(remain2) > 1 else float('inf')
            
            result = max(result, total - min(remove1, remove2))
        
        else:
            remove1 = remain2[0] if len(remain2) > 0 else float('inf')
            remove2 = remain1[0] + remain1[1] if len(remain1) > 1 else float('inf')

            result = max(result, total - min(remove1, remove2))
        
        return result 
