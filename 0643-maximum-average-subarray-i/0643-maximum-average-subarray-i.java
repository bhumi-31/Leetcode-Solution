class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxi = 0;

        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }

        maxi = sum;

        for(int i = k; i < nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];
            maxi = Math.max(maxi, sum);
        }

        return maxi/k;
    }
}