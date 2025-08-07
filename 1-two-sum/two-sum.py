import numpy as np 

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = np.array(nums)
        seen = {}

        for i, num in enumerate(arr):
            if (target - num) in seen:
                return [i, seen[target-num]]
            seen[num] = i
        