class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;
        ans.resize(n);

        int mul = 1;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                count++;
            }
            else{
                mul *= nums[i];
            }
        }

        if(count > 1){
            return ans;
        }

        for(int i=0; i<n; i++){
            if(count == 1){
                if(nums[i] == 0){
                    ans[i] = mul;
                }
                else{
                    ans[i] = 0;
                }
            }
            else{
                ans[i] = mul/ nums[i];
            }
        }
        return ans;
    }
};