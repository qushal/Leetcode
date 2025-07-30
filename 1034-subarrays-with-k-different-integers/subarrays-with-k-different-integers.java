class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int i = 0;
        int j = 0;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < n){
            map.merge(nums[j], 1, Integer::sum);
            if(map.size() == k + 1){
                map.remove(nums[i++]);

                while(map.containsKey(nums[i-1]) && map.get(nums[i-1]) == 0){
                    map.remove(nums[i-1]);
                }
                prefix = 0;
            }
            if(map.size() == k){
                while(map.get(nums[i]) > 1){
                    map.put(nums[i], map.get(nums[i]) - 1);
                    i++;
                    prefix++;
                }
                count += (prefix + 1);
            }
            j++;
        }
        return count;
    }
}