class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long min = -1_000_000_0000L;
        long max = 1_000_000_0000L;
        long ans = 0;

        while(min <= max){
            long mid = min + (max-min)/2;
            long count = countk(nums1, nums2, mid);

            if(count < k){
                min = mid + 1;
            }
            else{
                ans = mid;
                max = mid - 1;
            }
        }
        return ans;
    }

    public long countk(int [] nums1, int[] nums2, long midProduct){
        long count = 0;
        // iterate for every value in nums1
        for(int i=0; i<nums1.length; i++){
            int n = nums2.length;
            // we are at nums[i]
            // now apply binary search on nums2 to find the possible order idx of mid 
            int min = 0;
            int max = n-1;
            
            if(nums1[i] >= 0){
                int m = -1;
                while(min <= max){
                    int mid = min + (max - min)/2;
                    long product =  1L * nums2[mid] * nums1[i];
                    if(product <= midProduct){
                        m = mid;
                        min = mid + 1;
                    }
                    else{
                        max = mid - 1;
                    }
                }
                count += (m + 1);
            }
            else{
                int m = n;
                while(min <= max){
                    int mid = min + (max-min)/2;
                    long product =  1L * nums1[i] * nums2[mid];
                    if(product <= midProduct){
                        m = mid;
                        max = mid - 1;
                    }
                    else{
                        min = mid + 1;
                    }
                }
                count += (nums2.length - m);
            }
        }
        return count;
    }
}