class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[None] * 3 for _ in range(n+1)]
        
        @lru_cache(None)
        def solve(i, remain):
            if i >= n:
                return 0 if remain == 0 else float('-inf')
            
            if dp[i][remain] is not None:
                return dp[i][remain]   

            take = nums[i] + solve(i+1, (remain + nums[i]) % 3)
            skip = solve(i+1, remain)
            dp[i][remain] = max(take, skip)
            return dp[i][remain]
        
        return solve(0, 0)