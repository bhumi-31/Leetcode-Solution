class Solution {
    public boolean isArrive(int[] dist, int mid, double hour){
        double totalTime = 0;

        for(int i = 0; i < dist.length - 1; i++){
            totalTime += Math.ceil((double)dist[i]/mid);
        }

        totalTime += (double)dist[dist.length - 1]/mid;

        if(totalTime <= hour){
            return true;
        }else{
            return false;
        }
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) {
            return -1;
        }
        int start = 1;
        int end = (int)Math.pow(10, 7);

        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isArrive(dist, mid, hour)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}