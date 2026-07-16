class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n2; i++){
            map.put(nums2[i], i);
        }

        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                int idx = map.get(nums1[i]);

                ans[i] = -1;

                for(int j = idx + 1; j < n2; j++){
                    if(nums2[j] > nums1[i]){
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
        }

        return ans;
    }
}