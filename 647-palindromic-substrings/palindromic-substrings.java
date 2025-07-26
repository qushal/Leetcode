class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                if(i==j) dp[i][j] = true;
                else if(i == j+1) dp[i][j] = (s.charAt(i) == s.charAt(j));
                else dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i-1][j+1];

                if(dp[i][j] == true) count++;
            }
        }
        return count;
    }
}