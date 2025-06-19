class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num: nums){
            x = x ^ num;
        }
        // x      = 10110100
        // x & -x = 00000100      we get the first set 
        int b = x & -x;
        int buck1 = 0;
        int buck2 = 0;
        for(int num: nums){
            if((num & b) == 0){
                buck1 ^= num;
            }
            else{
                buck2 ^= num;
            }
        }
        return new int[]{buck1, buck2};
    }
}