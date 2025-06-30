class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2) return nums[0];
        int profit[] = new int[n];
        profit[0] = nums[0];
        profit[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int rob = nums[i] + profit[i-2];
            profit[i] = Math.max(profit[i-1], rob);
        }
        return profit[n-1];
    }
}