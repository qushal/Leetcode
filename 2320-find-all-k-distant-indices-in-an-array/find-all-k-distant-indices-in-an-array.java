class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> ans = new TreeSet<>();
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == key){
                int start = Math.max(0, i-k);
                int end = Math.min(n-1, i+k);
                while(start <= end){
                    ans.add(start++);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}