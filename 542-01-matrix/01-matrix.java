class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int [][] dist = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i], -1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};
        while(!q.isEmpty()){
            int [] pair = q.poll();
            int i = pair[0], j = pair[1];
            for(int a=0; a<4; a++){
                int ni = i + dx[a];
                int nj = j + dy[a];
                if(ni >= 0 && nj >= 0 && ni < m && nj < n && dist[ni][nj] == -1){
                    dist[ni][nj] = dist[i][j] + 1;
                    q.offer(new int[] {ni, nj});
                }
            }
        }
        return dist;
    }
}