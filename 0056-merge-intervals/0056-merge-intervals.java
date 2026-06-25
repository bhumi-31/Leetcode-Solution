class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!ans.isEmpty() && ans.get(ans.size() - 1)[1] >= end){
                continue;
            }

            for(int j = i + 1; j < n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                }
            }
            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}