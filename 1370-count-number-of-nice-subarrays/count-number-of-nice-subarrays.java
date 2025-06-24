class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }
    public int atmost(int [] nums, int k){
        int i=0, j=0;
        int n=nums.length;
        int oddCount = 0;
        int ans = 0;
        while(j<n){
            if((nums[j] % 2) == 1) oddCount++;
            while(i < n && oddCount > k){
                if((nums[i++] % 2) == 1) oddCount--;
            }
            ans += (j-i);
            j++;
        }
        return ans;
    }
}