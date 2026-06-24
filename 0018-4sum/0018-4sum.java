class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                int si = j + 1;
                int ei = nums.length - 1;

                while(si < ei){
                    List<Integer> res = new ArrayList<>();
                    long sum = (long)nums[i] + nums[j] + nums[si] + nums[ei];

                    if(sum == target){
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[si]);
                        res.add(nums[ei]);
                        ans.add(res);
                        si++;
                        ei--;


                        while(si < ei && nums[si] == nums[si - 1]) si++;
                        while(si < ei && nums[ei] == nums[ei + 1]) ei--;
                    }else if(sum < target){
                        si++;
                    }else{
                        ei--;
                    }
                }
            }
        }
        return ans;
    }
}