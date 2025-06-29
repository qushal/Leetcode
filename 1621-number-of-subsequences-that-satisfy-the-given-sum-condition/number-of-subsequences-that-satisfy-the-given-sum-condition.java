class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int m = 1000000007;
        int n = nums.length;
        int i=0, j=n-1;

        int [] pow = new int[n];
        pow[0] = 1;
        for(int k=1; k<n; k++){
            pow[k] = (pow[k-1] * 2) % m;
        }
        long count = 0;
        while(i<=j){
            if((nums[i] + nums[j]) <= target){
                count = (count + pow[j-i]) % m;
                i++;
            }
            else{
                j--;
            }
        }
        return (int) count % m;
    }
}