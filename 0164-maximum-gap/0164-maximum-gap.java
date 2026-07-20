class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int maxi = Integer.MIN_VALUE;

        if(n < 2){
            return 0;
        }

        int i = 0;
        while(i < n - 1){
            int diff = nums[i+1] - nums[i];
            maxi = Math.max(maxi, diff);
            i++;
        }
        return maxi;
    }
}