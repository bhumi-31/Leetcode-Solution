class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int maxLen = 0;
        int countZero = 0;

        for(int r = 0; r < nums.length; r++){
            if(nums[r] == 0){
                countZero++;
            }

            while(countZero > 1){
                if(nums[l] == 0){
                    countZero--;
                }
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen - 1;
    }
}