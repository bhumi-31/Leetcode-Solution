class Solution {
    public int findMax(int[] nums){
        int maxi = 0;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }

    public int sum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }

        return sum;
    }

    public boolean isLargeSum(int[] nums, int MaxiSum, int k){
        int subarray = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= MaxiSum){
                sum = sum + nums[i];
            }else{
                subarray++;
                sum = nums[i];

                if(subarray > k){
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int start = findMax(nums);
        int end = sum(nums);
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isLargeSum(nums, mid, k)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}