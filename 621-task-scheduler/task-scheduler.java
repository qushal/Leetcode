class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        int time = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int f: freq){
            if(f>0) q.offer(f);
        }

        while(!q.isEmpty()){
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while(cycle-- > 0 && !q.isEmpty()){
                int currentFreq = q.poll();
                if(currentFreq > 1){
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }

            store.forEach(q::offer);

            time += (q.isEmpty() ? taskCount : n+1);
        }
        return time;
    }
}