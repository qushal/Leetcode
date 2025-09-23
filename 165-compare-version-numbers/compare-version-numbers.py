class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = list(map(int, version1.split('.')))
        v2 = list(map(int, version2.split('.')))

        n, m = len(v1), len(v2)
        while(n < m):
            v1.append(0)
            n += 1
        while(m < n):
            v2.append(0)
            m += 1

        if v1 > v2: return 1
        if v2 > v1: return -1
        return 0