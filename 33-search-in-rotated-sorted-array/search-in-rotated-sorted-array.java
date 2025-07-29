class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1; 
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        int pivot = l;
        l = 0;
        r = n-1;
        
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            l = pivot;
            r = n - 1;
        } else {
            l = 0;
            r = pivot - 1;
        }
        

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else r = mid -1;
        }
        return -1;
    }
}