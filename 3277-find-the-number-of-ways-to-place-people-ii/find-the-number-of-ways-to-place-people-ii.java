class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else{
                return Integer.compare(b[1], a[1]);
            }
        });

        int count = 0;
        int n = points.length;
        for(int i=0; i<n; i++){
            int top = points[i][1];
            int bot = Integer.MIN_VALUE;

            for(int j=i+1; j<n; j++){
                int y = points[j][1];
                if(bot < y && y <= top){
                    count++;
                    bot = y;
                    if(bot == top) break;
                }
            }
        }
        return count;
    }
}


// left coordinate must be smaller or equal 
// right coordinate must be greater or equal