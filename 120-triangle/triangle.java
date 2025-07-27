class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int d[]:dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return helper(triangle, 0, 0, dp);
    }
    public int helper(List<List<Integer>> triangle, int row, int col, int dp[][]){
        if(row == triangle.size()) return 0;
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int down = helper(triangle, row+1, col, dp);
        int right = helper(triangle, row+1, col+1, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, right);
    }
}