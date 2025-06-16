class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;
        int prev = nums[0];
        for(int num: nums){
            ans = Math.max(ans, num - prev);
            prev = Math.min(num, prev);
        }
        return ans == 0? -1: ans;
    }
}