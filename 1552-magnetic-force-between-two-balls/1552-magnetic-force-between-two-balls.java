class Solution {
    public boolean canPlace(int[] arr, int dist, int m){
        int lastPosition = arr[0];
        int balls = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - lastPosition >= dist){
                balls++;
                lastPosition = arr[i];
            }

            if(balls == m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int start = 1;
        int end = position[n-1] - position[0];

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canPlace(position, mid, m)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}