class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++){
            maxheap.offer(nums[i]);
        }
        
        while(k > 1){
            maxheap.poll();
            k--;
        }
        return maxheap.peek();
    }
}