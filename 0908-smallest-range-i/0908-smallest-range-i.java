class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        return Math.max(0, maxi - mini - 2*k);
    }
}