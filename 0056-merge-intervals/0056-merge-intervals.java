class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(intervals[i][0] <= ans.get(ans.size() - 1)[1]){
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }else{
                ans.add(new int[]{start, end});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}