class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }

        int si = 0;
        int ei = index;

        while(si <= ei){
            int mid = si + (ei - si)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }
        }

        si = index + 1;
        ei = nums.length - 1;

        while(si <= ei){
            int mid = si + (ei - si)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }
        }

        return -1;
    }
}