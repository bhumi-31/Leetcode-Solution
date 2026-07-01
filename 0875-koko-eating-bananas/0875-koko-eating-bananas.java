class Solution {
    public int findMax(int[] piles){
        int maxi = 0;
        for(int p : piles){
            maxi = Math.max(maxi, p);
        }

        return maxi;
    }
    public boolean canEat(int[] piles, int h, int k){
        int totalHours = 0;

        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i]/k);
        }

        if(totalHours <= h){
            return true;
        }else{
            return false;
        }
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 0;
        int end = findMax(piles);
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canEat(piles, h, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}