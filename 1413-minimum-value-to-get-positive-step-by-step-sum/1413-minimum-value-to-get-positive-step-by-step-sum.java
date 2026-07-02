class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;

        while(true){
            int sum = startValue;
            boolean possible = true;
            
            for(int j = 0; j < nums.length; j++){
                sum = sum + nums[j];

                if(sum < 1){
                    possible = false;
                    break;
                }
            }

            if(possible){
                return startValue;
            }

            startValue++;
        }
    }
}