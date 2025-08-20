class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[-1 for _ in range(n)] for _ in range(m)]
        return self.helper(0, 0, m, n, memo)
    def helper(self, i, j, m, n, memo):
        if(i == m-1 and j == n-1):
            return 1
        if(i >= m or j >= n):
            return 0
        if(memo[i][j] != -1):
            return memo[i][j]
        memo[i][j] = self.helper(i+1,j, m, n, memo) + self.helper(i, j+1, m, n, memo)
        return memo[i][j]