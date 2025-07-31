class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                    ans = sum;
                }
                if(sum > target){
                    k--;
                }
                else if(sum == target){
                    return target;
                }
                else{
                    j++;
                }
            }
        }
        return ans;
    }
}