class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++){
            q.offer(stones[i]);
        }
        while(q.size() > 1){
            int a = q.poll();
            int b = q.poll();
            q.offer(a-b);
        }
        return q.peek();
    }
}