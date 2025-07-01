class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 0;
        int i=1; 
        while(i< n){
            while(i<n && word.charAt(i) == word.charAt(i-1)){
                i++;
                ans++;
            }
            i++;
        }
        return ans + 1;
    }
}