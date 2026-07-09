class Solution {
    public int binary(int[]nums, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binary(nums, target, mid + 1, end);
        }else{
            return binary(nums, target, start, mid - 1);
        }
    }
    public int search(int[] nums, int target) {
        int n = nums.length;

        return binary(nums, target, 0, n - 1);
    }
}