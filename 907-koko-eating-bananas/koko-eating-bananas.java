class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1; 
        int max = Arrays.stream(piles).max().getAsInt();
        while(min < max){
            int mid = min + (max - min)/2;
            if(isPossible(mid, h, piles)){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean isPossible(int k, int h, int [] piles){
        int count = 0;
        for(int p: piles){
            count += (p + k - 1) /k;
        }
        return count <= h ? true : false;
    }
}