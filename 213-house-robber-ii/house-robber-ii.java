class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)), helper(Arrays.copyOfRange(nums, 1, n)));
    }
    public int helper(int nums[]){
        int n = nums.length; 
        if (n == 0) return 0;
        if (n == 1) return nums[0];
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