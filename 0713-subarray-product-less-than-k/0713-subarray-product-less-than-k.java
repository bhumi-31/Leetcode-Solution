class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int pdt = 1;
        int count = 0;
        if(k <= 1) return 0;

        for(int right = 0; right < nums.length; right++){
            pdt = pdt * nums[right];

            while(pdt >= k){
                pdt = pdt/nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}