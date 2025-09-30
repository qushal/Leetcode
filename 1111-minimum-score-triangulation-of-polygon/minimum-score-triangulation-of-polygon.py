class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        dp = [[-1] * n for _ in range(n)]
        
        def solve(i, j):
            if j - i < 2:
                return 0

            if dp[i][j] != -1:
                return dp[i][j]

            result = sys.maxsize
            for k in range(i+1, j):
                ans = solve(i,k) + values[i]*values[j]*values[k] + solve(k, j)
                result = min(result, ans)

            dp[i][j] = result
            return result

        return solve(0, n-1)
