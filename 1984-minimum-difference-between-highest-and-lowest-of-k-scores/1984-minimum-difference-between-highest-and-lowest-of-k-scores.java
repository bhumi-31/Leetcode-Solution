class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        if(n == 1){
            return 0;
        }

        int left = 0;
        int mini = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++){

            if(right - left + 1 == k){
                mini = Math.min(mini, nums[right] - nums[left]);
                left++;
            }
        }

        return mini;
    }
}