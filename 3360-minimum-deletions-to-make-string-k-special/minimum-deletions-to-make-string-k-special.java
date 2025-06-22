class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = word.length();

        for(int i=0; i<26; i++){
            int del = 0;

            for(int j=0; j<26; j++){
                if(i==j) continue;

                if(freq[j] < freq[i]){
                    del += freq[j];
                }
                else if(Math.abs(freq[i] - freq[j]) > k){
                    del += (Math.abs(freq[j] - freq[i]) - k);
                }
            
            }
            ans = Math.min(del, ans);
        }

        return ans;

    }
}