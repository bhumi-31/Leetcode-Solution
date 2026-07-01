class Solution {
    public int findMin(int[] bloomDay){
        int mini = 0;
        for(int b : bloomDay){
            mini = Math.min(mini, b);
        }

        return mini;
    }

    public int findMax(int[] bloomDay){
        int maxi = 0;
        for(int b : bloomDay){
            maxi = Math.max(maxi, b);
        }

        return maxi;
    }

    public boolean canBloom(int[] bloomDay, int days, int m, int k){
        int count = 0;
        int noOfBucket = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= days){
                count++;
            }else{
                noOfBucket += count/k;
                count = 0;
            }
        }

        noOfBucket += count/k;
        return noOfBucket >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int start = findMin(bloomDay);
        int end = findMax(bloomDay);
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canBloom(bloomDay, mid, m, k)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}