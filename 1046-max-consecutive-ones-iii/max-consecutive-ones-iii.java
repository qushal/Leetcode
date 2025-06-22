class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length; 
        int ans = 0;
        int xeroCount = 0;
        while(right < n){
            if(nums[right] == 0){
                xeroCount++;
            }
            while(xeroCount > k){
                if(nums[left] == 0) xeroCount--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}