class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;

        while(left < right){
            int ht = Math.min(height[left], height[right]);
            int wi = right  - left;

            area = Math.max(area, ht * wi);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return area;
    }
}