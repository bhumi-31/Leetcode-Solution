class Solution {
    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        vis[src] = true;

        for(int neigh : graph.get(src)){
            if(!vis[neigh]){
                dfs(neigh, graph, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
        if(isConnected[i][j] == 1){
            graph.get(i).add(j);
        }
    }
}

        boolean[] vis = new boolean[n];

        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i, graph, vis);
            }
        }

        return count;
    }
}