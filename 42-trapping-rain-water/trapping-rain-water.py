class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        leftmax = [0] * n
        leftmax[0] = 0

        for i in range(1,n):
            if height[i] > height[leftmax[i-1]]:
                leftmax[i] = i
            else:
                leftmax[i] = leftmax[i-1]

        rightmax = [0] * n
        rightmax[n-1] = n-1

        for i in range(n-2, 0, -1):
            if height[i] < height[rightmax[i+1]]:
                rightmax[i] = rightmax[i+1]
            else:
                rightmax[i] = i
        
        ans = 0
        for i in range(0, n):
            ans += min(height[leftmax[i]], height[rightmax[i]]) - height[i]
        return ans
