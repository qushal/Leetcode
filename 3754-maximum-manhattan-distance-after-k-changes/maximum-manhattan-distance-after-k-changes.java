class Solution {
    public int maxDistance(String s, int k) {
        int n = 0, south = 0, w = 0, e = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'N') n++;
            else if(c == 'S') south++;
            else if(c == 'W') w++;
            else e++;

            int MD = Math.abs(n-south) + Math.abs(e-w);
            ans = Math.max(ans, Math.min(MD + 2*k, i+1));

        }
        return ans;
    }
}