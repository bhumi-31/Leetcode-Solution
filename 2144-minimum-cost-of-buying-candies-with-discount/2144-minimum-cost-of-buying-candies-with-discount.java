class Solution {
    public void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        reverse(cost);

        int n = cost.length;

        if(n == 2){
            return cost[0] + cost[1];
        }

        int count = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            count++;
            if(count == 3){
                count = 0;
                continue;
            }

            ans += cost[i];

        }

        return ans;
    }


}