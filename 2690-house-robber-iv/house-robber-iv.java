class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        if(n==0) return 0;
        if(n < 2) return nums[0];
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        while(min < max){
            int mid = min + (max - min)/2;
            int c = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] <= mid){
                    c++; i++;
                }
            }
            if(c >= k) max = mid;
            else min = mid + 1;
        }
        return min;
    }
}