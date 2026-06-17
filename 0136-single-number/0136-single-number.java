class Solution {
    public int singleNumber(int[] nums) {
        int xoor = 0;

        for(int num : nums){
            xoor = xoor ^ num;
        }

        return xoor;
    }
}