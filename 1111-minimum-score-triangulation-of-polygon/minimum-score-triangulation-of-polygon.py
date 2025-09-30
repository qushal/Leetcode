class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        @lru_cache(None)
        def solve(i, j):
            if j - i < 2:
                return 0

            result = sys.maxsize
            for k in range(i+1, j):
                ans = solve(i,k) + values[i]*values[j]*values[k] + solve(k, j)
                result = min(result, ans)

            return result

        n = len(values)
        return solve(0, n-1)
