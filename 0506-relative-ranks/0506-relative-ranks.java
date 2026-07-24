class Solution {
    class Pair{
        int score;
        int idx;

        public Pair(int score, int idx){
            this.score = score;
            this.idx = idx;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.score - a.score);

        for(int i = 0; i < score.length; i++){
            pq.add(new Pair(score[i], i));
        }

        String[] ans = new String[score.length];

        int rank = 1;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int s = curr.score;
            int idx = curr.idx;

            if(rank == 1){
                ans[idx] = "Gold Medal";
            }
            else if(rank == 2){
                ans[idx] = "Silver Medal";
            }
            else if(rank == 3){
                ans[idx] = "Bronze Medal";
            }
            else{
                ans[idx] = Integer.toString(rank);
            }

            rank++;
        }

        return ans;
    }
}