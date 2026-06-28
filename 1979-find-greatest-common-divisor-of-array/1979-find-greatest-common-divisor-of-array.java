class Solution {
    public int gcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            mini = Math.min(nums[i], mini);
            maxi = Math.max(nums[i], maxi);
        }

        return gcd(mini, maxi);
    }
}