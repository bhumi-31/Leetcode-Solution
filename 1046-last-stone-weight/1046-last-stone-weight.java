class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }

        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if(stone1 != stone2){
                pq.offer(stone1 - stone2);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }else{
            return pq.peek();
        }
    }
}