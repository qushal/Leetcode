class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        result = 0

        def solve(l : int, r : int) -> int:
            L = 1
            S = 1
            total_steps = 0
            while(L <= r):
                R = 4*L - 1
                start = max(L, l)
                end   = min(r, R)
                if start <= end:
                    total_steps += ((end - start + 1) * S)
                S += 1
                L = 4*L
            
            return total_steps

        for l,r in queries:
            steps = solve(l, r)
            result += math.ceil(steps/2)
            
        return result