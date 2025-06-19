class Solution {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int count = 0;
        int maxCount = 0;
        for(int num: nums){
            if(num == max){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count = 0;
            }
        }
        return maxCount;
        
    }
}