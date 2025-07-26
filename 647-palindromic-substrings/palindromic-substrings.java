class Solution {
    public int countSubstrings(String s) {
        if(s.length() < 2) return s.length();
        int count = s.length();
        for(int i=1; i<s.length(); i++){
            for(int j=0; j<i; j++){
                if(isPal(s.substring(j, i+1))) count++;
            }
        }
        return count;
    }

    public boolean isPal(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}