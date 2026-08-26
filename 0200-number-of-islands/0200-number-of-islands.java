class Solution {
    public void dfs(int nrow, int ncol , int[][] vis, char[][] grid){
        if(nrow < 0 || ncol < 0 || nrow >= grid.length || ncol >= grid[0].length || vis[nrow][ncol] == 1 || grid[nrow][ncol] == '0'){
            return;
        }

        vis[nrow][ncol] = 1;

        dfs(nrow + 1, ncol, vis, grid);
        dfs(nrow - 1, ncol, vis, grid);
        dfs(nrow , ncol + 1, vis, grid);
        dfs(nrow , ncol - 1, vis, grid);

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j]== 0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}