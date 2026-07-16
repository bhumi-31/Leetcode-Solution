class Solution {
    public boolean validMountainArray(int[] arr) {


        int n = arr.length ;

        int peak = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[peak]) {
                peak = i;
            }
        }

        if(peak == 0 || peak == n - 1){
            return false;
        }

        for(int i = 0; i < peak; i++){
            if(arr[i] >= arr[i+1]){
                return false;
            }
        }

        for(int i  = peak; i < n - 1; i++){
            if(arr[i] <= arr[i+1]){
                return false;
            }
        }

        return true;
    }
}