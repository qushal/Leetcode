class NumMatrix {
    int prefixSum[][] ;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length; 
        int c = matrix[0].length;
        prefixSum = new int[r+1][c+1];

        for(int i=1; i<r+1; i++){
            for(int j=1; j<c+1; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] -
                                    prefixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {    

        // row1 to row 2 
        // col1 to col2 
        int r1 = row1 + 1;
        int r2 = row2 + 1;
        int c1 = col1 + 1;
        int c2 = col2 + 1;

        int ans = prefixSum[r2][c2] - prefixSum[r1-1][c2] - prefixSum[r2][c1-1] + prefixSum[r1 - 1][c1 - 1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */