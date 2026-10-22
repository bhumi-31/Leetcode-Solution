class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxi = 0;
        int countZero = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                countZero++;
            }

            while(countZero > k){

                if(nums[left] == 0){
                    countZero--;
                }
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
}