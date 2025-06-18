class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(nums);
        int i=0; 
        while(i < n/3){
            for(int j=0; j<3; j++){
                ans[i][j] = nums[j  + (i * 3)];
            }
            if(ans[i][2] - ans[i][0] > k){
                return new int[][]{};
            }
            i++;
        }
        return ans;
    }
}