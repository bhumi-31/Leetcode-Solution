class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();

        map.put(0, 1L);

        int prefixXor = 0;
        long ans = 0;

        for(int i = 0; i < nums.length; i++){
            prefixXor ^= nums[i];

            ans += map.getOrDefault(prefixXor, 0L);

            map.put(prefixXor, map.getOrDefault(prefixXor, 0L) + 1);
        }
        return ans;
    }
}