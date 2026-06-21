class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxi = Math.max(nums[i] + maxi, nums[i]);
            res = Math.max(res, maxi);
        }
        return res;
    }
}