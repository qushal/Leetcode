class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int ans = word.length();
        int cumulative_deleted = 0;

        for(int i=0; i<26; i++){
            int del = cumulative_deleted;

            for(int j=25; j>i; j--){
                if((freq[j] - freq[i]) <=k) break;

                del += (freq[j] - freq[i] - k);
            }
            ans = Math.min(ans, del);
            cumulative_deleted += freq[i];
        }
        
        return ans;

    }
}