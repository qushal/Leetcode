class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.merge(nums[i], 1, Integer::sum);
        }
        // now sort this  in descending order
        Map<Integer, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed()).
        collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> a,
            LinkedHashMap::new

        ));
        int ans[] = new int[k];
        int j=0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if(j==k) break;
            ans[j] = entry.getKey();
            j++;
        }
        return ans;
    }
}