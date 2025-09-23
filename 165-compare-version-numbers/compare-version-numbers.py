class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        i = 0
        j = 0
        n = len(version1)
        m = len(version2)

        while(i< n and j < m):
            digit1 = 0
            while i<n and version1[i] != '.':
                digit1 *= 10
                digit1 += int(version1[i])
                i += 1
            i += 1

            digit2 = 0
            while j < m and version2[j] != '.':
                digit2 *= 10
                digit2 += int(version2[j])
                j += 1
            j+=1 

            if(digit1 > digit2):
                return 1
            elif(digit2 > digit1):
                return -1
        while i<n:
            if version1[i] == '.' or version1[i] == '0':
                pass
            else:
                return 1
            i += 1

        while j<m:
            if version2[j] == '.' or version2[j] == '0':
                pass
            else:
                return -1
            j += 1
        
        return 0

