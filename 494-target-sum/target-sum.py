class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)

        @lru_cache(None)
        def helper(curr_sum, idx):
            if idx == n:
                return 1 if curr_sum == target else 0

            plus = helper(curr_sum + nums[idx], idx + 1)
            minus = helper(curr_sum - nums[idx], idx + 1)
            return plus + minus
        
        return helper(0, 0)
            