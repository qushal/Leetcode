class Solution {
    class Pair implements Comparable<Pair>{
        int x; int y; double dist;
        Pair(int x, int y, double d){
            this.x = x;
            this.y = y;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair other){
            return Double.compare(this.dist, other.dist);
        }
        
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int p[]: points){
            int x = p[0];
            int y = p[1];
            double dist = Math.sqrt(x*x + y*y);
            q.offer(new Pair(x, y, dist));
        }
        int ans[][] = new int[k][2];
        for(int i=0; i<k; i++){
            Pair p = q.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }

}