class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == key){
                int start = Math.max(0, i-k);
                if(ans.size() > 0){
                    start = Math.max(start, ans.get(ans.size()-1) + 1);
                }
                int end = Math.min(n-1, i+k);
                while(start <= end){
                    ans.add(start++);
                }
            }
        }
        return ans;
    }
}