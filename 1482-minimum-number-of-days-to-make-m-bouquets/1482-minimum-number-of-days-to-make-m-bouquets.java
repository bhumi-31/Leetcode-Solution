class Solution {
    public int findMin(int[] bloomDay){
        int mini = bloomDay[0];

        for(int b : bloomDay){
            mini = Math.min(b, mini);
        }

        return mini;
    }

    public int findMax(int[] bloomDay){
        int maxi = bloomDay[0];

        for(int b : bloomDay){
            maxi = Math.max(b, maxi);
        }

        return maxi;
    }

    public boolean canMake(int[] bloomDay, int m, int k, int days){
        int flowerBloom = 0;
        int bouquet = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= days){
                flowerBloom++;
            }else{
                flowerBloom = 0;
            }

            if(flowerBloom == k){
                bouquet++;
                flowerBloom = 0;
            }
        }

        return bouquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int start = findMin(bloomDay);
        int end = findMax(bloomDay);

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canMake(bloomDay, m, k, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}