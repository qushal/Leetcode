class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> [] heap = new ArrayList[nums.length+1];
        for(int key: map.keySet()){
            int val = map.get(key);
            if(heap[val] == null){
                heap[val] = new ArrayList<>();
            }
            heap[val].add(key);
        }
        int ans[] = new int[k];
        int j=0;
        for(int i=nums.length; i>=0; i--){
            if(heap[i] == null) continue;
            List<Integer> part = heap[i];
            for(int x: part){
                if(j == k) break;
                ans[j++] = x;
            }
            
        }
        return ans;
    }
}