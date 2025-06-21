class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int i=0;
        int j=0;
        while(j < n){  
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans, j- i + 1);
                j++;
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}