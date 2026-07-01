class Solution {
    public int findMax(int[] nums){
        int maxi = 0;
        for(int n : nums){
            maxi = Math.max(maxi, n);
        }

        return maxi;
    }

    public boolean canDivide(int[] nums, int divisor, int threshold){
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double)nums[i]/(double)divisor);
        }

        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = findMax(nums);

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canDivide(nums, mid, threshold)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}