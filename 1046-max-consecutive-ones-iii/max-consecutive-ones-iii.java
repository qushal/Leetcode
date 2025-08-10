class Solution {
    public int longestOnes(int[] nums, int k) {
        int xero = 0;
        int ans = 0;
        int i=0, j=0;
        while(j < nums.length){
            if(nums[j] == 0) xero++;
            while(xero > k && i <= j){
                if(nums[i] == 0) xero--;
                i++;
            }
            if(xero <= k){
                ans = Math.max(ans, j-i+1);
            }
            j++;
        }
        return ans;
    }
}