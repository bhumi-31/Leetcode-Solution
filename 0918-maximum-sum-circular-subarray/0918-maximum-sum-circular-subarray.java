class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        long totalSum = 0;
        long currMax = 0;
        long maxSum = nums[0];
        long currMin = 0;
        long minSum = nums[0];

        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            //find normal sum using kadane's

            currMax = Math.max(nums[i], nums[i] + currMax);
            maxSum = Math.max(currMax, maxSum);


            currMin = Math.min(nums[i], nums[i] + currMin);
            minSum = Math.min(currMin, minSum);
        }

        if(maxSum < 0){
            return (int)maxSum;
        }

        return (int) Math.max(maxSum, totalSum - minSum);
    }
}