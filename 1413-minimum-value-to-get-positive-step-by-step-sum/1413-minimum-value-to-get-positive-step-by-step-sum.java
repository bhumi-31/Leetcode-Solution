class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minPrefix = 0;

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            minPrefix = Math.min(minPrefix, sum);
        }

        if(minPrefix < 0){
            return 1 - minPrefix;
        }

        return 1;
    }
}