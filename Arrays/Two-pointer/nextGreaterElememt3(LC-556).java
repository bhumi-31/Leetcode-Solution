class Solution {
    public void reverse(int[] nums, int si, int ei){
        while(si < ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
    public int nextGreaterElement(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int[] nums = new int[ch.length];
        for(int i = 0; i < ch.length; i++){
            nums[i] = ch[i] - '0';
        }

        int len = nums.length;
        int index = -1;

        for(int i = len - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }

        if(index == -1) return -1;

        for(int i = len - 1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, len - 1);

        long ans = 0;
        for(int d : nums){
            ans = ans * 10 + d;
        }

         return ans > Integer.MAX_VALUE ? -1 : (int) ans;

    }
}