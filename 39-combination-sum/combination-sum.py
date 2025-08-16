class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        lst = []
        self.helper(candidates, 0, target, ans, [])
        return ans
    def helper(self, candidates, idx, target, ans, lst):
        if target == 0:
            ans.append(lst.copy())
            return
        if idx == len(candidates) or target < 0:
            return
        
        # include
        lst.append(candidates[idx])
        self.helper(candidates, idx, target-candidates[idx], ans, lst)
        lst.pop()

        # exclude
        self.helper(candidates, idx + 1, target, ans, lst)