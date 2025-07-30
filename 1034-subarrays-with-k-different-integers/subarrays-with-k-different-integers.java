class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }   
    public int atmost(int nums[], int k){
        // we have to find all possible subarrays that has atmost k distinct elements
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, i =0;
        for(int j=0; j<n; j++){
            map.merge(nums[j], 1, Integer:: sum);
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
}