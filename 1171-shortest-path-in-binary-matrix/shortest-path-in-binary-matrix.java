class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        boolean [][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        q.offer(new Pair(0,0));
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();

            for(int k=0; k<size; k++){
                Pair curr = q.poll();
                int i = curr.x;
                int j = curr.y;
                visited[i][j] = true;

                for(int d[] : dir){
                    int row = i + d[0];
                    int col = j + d[1];
                    if(row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 0 && !visited[row][col]){
                        q.add(new Pair(row, col));
                        visited[row][col] = true;
                        if(visited[n-1][n-1] == true){
                            return level + 1;
                        }
                    }
                }
            }
            
            
        }
        if(visited[n-1][n-1] == false) return -1;
        return level;
    }
}