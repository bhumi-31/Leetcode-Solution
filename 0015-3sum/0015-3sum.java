class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int si = i + 1;
            int ei = nums.length - 1;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(si < ei){
                List<Integer> ans = new ArrayList<>();
                int sum = nums[i] + nums[si] + nums[ei];

                if(sum == 0){
                    ans.add(nums[i]);
                    ans.add(nums[si]);
                    ans.add(nums[ei]);
                    res.add(ans);
                    si++;
                    ei--;

                    while(si < ei && nums[si] == nums[si - 1]) si++;
                    while(si < ei && nums[ei] == nums[ei + 1]) ei--;
                }else if(sum < 0){
                    si++;
                }else{
                    ei--;
                }
            }
        }
        return res;
    }
}