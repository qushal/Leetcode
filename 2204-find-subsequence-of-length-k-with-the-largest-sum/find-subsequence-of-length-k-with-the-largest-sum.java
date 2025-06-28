class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int [][] sorted = new int[n][2];
        for(int i=0; i<n; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a,b) -> Integer.compare(a[0], b[0]));
        int ans[] = new int[k];
        int [][] part = Arrays.copyOfRange(sorted, n-k , n);
        Arrays.sort(part , (a,b) -> Integer.compare(a[1], b[1]));
        int a = 0;
        for(int i=0; i<part.length; i++){
            ans[a++] = part[i][0];
        }
        return ans;
    }
}