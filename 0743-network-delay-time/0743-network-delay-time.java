class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.get(u).add(new int[]{v,w});
        }

        int dist[] = new int[n+1];
        boolean vis[] = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[k] = 0;
        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair p =pq.poll();
            int curr = p.node;
            int cost = p.cost;

            if(!vis[curr]){
                vis[curr] = true;

                for(int[] neigh : graph.get(curr)){
                    int v = neigh[0];
                    int wt = neigh[1];

                    if(dist[curr] + wt < dist[v]){
                        dist[v] = dist[curr] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}