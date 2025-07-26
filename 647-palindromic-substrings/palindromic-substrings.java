class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        int n = s.length();
        for(int i=0; i<n; i++){
            helper(s, i, i+1);
            helper(s, i, i);
        } 
        return count;
    }
    public void helper(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}