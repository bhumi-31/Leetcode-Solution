class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > K){
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */