class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int si = 0;
        int ei = n - 1;

        while(si < ei){
            int mid = si + (ei - si)/2;

            if(nums[mid] < nums[ei]){
                ei = mid;
            }else{
                si = mid + 1;
            }
        }
        return nums[si];
    }
}