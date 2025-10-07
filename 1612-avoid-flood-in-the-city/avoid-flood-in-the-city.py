class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        map = {}
        dryDays = []
        ans = [1] * len(rains)

        for i in range(n):
            lake = rains[i]
            if lake == 0:
                insort(dryDays, i)           #------
            else:
                ans[i] = -1

                if lake in map:
                    j = bisect_right(dryDays, map[lake])

                    if j == len(dryDays):
                        return []
                    
                    dryDay = dryDays[j]
                    ans[dryDay] = lake
                    dryDays.pop(j)
                
                map[lake] = i
        return ans

            