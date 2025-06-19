class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int prefixXor[] = new int[n];
        prefixXor[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }

        int ans[] = new int[queries.length];
        int j =0;
        for(int q[] : queries){
            int left = q[0];
            int right = q[1];
            if(left == 0){
                ans[j++] = prefixXor[right];
            }
            else{
                ans[j++] = prefixXor[right] ^ prefixXor[left -1];
            }
            
        }
        return ans;
    }
}