class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length; i++){
            int pdt = 1;
            for(int j = i; j < nums.length; j++){
                pdt = pdt * nums[j];
                maxi = Math.max(pdt, maxi);
            }
        }
        return maxi;
    }
}