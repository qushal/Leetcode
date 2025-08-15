class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n == 0:
            return 0
        
        left, right = 0, n-1
        lmax, rmax = 0, 0
        ans = 0
        
        while(left < right):
            if height[left] < height[right]:
                if height[left] >= lmax:
                    lmax = height[left]
                else:
                    ans += lmax - height[left]
                left += 1
            else:
                if height[right] >= rmax:
                    rmax = height[right]
                else:
                    ans += rmax - height[right]
                right -= 1
        return ans