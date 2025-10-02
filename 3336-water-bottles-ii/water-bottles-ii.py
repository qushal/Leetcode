class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        curr = numBottles
        ans = 0
        while curr >= numExchange:
            curr -= numExchange
            curr += 1
            ans += numExchange
            numExchange += 1
        ans += curr
        return ans


