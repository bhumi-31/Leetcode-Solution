class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int si = 0;
        int ei = n - 1;

        while(si < ei){
            int mid = si + (ei - si)/2;

            if(nums[mid] < nums[mid + 1]){
                si = mid + 1;
            }else{
                ei = mid;
            }
        }
        return si;
    }
}