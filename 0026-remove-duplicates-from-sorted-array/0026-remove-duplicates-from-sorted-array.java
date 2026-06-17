class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int k = 0;
        for(int num : set){
            nums[k++] = num;
        }

        return k;
    }
}