class Solution {
    public int maxProduct(int[] nums) {
        int maxPdt = nums[0];
        int minPdt = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = maxPdt;
                maxPdt = minPdt;
                minPdt = temp;
            }


            maxPdt = Math.max(nums[i], maxPdt * nums[i]);
            minPdt = Math.min(nums[i], minPdt * nums[i]);
            ans = Math.max(maxPdt, ans);
        }

        return ans;
    }
}