class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n = len(spells)
        m = len(potions)
        pairs = []
        potions.sort()
        for i in spells:
            val = (success + i - 1) // i
            adder = 0
            idx = bisect_left(potions, val)
            pairs.append(m - idx)
            
        return pairs