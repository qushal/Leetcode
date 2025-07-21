class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int n = intervals.length;
        int prev = intervals[0][1];
        for(int i=1; i<n; i++){
            if(prev > intervals[i][0]){
                count++;
            }
            else{
                prev = intervals[i][1];
            }
        }
        return count;
    }
}