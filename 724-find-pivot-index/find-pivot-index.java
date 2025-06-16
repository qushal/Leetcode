class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sumLeft = 0;
        int sumRight = 0;
        for(int i=0; i<n; i++){
            sumRight += nums[i];
        }

        for(int i=0; i<n; i++){
            sumRight -= nums[i];
            if(sumLeft == sumRight) return i;

            sumLeft += nums[i];

        }
        return -1;
    }
}