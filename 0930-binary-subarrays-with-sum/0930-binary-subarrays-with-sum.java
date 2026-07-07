class Solution {
    public int noOfSubarray(int[] nums, int goal){
        if (goal < 0) return 0;
        int left = 0;
        int count = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++){
            sum = sum + nums[right];

            while(sum > goal){
                if(nums[left] == 1){
                    sum = sum - nums[left];
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return noOfSubarray(nums, goal) - noOfSubarray(nums, goal - 1);
    }
}