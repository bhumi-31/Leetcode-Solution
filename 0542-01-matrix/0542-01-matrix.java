class Solution {
    public class Info{
        int row;
        int col;
        int steps;

        public Info(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Info> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new Info(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] drow = {0, -1, 0, 1};
        int[] dcol = {-1, 0, 1, 0};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int step = q.peek().steps;
            q.poll();

            ans[r][c] = step;
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Info(nrow, ncol, step + 1));
                }
            }
        }
        return ans;
    }
}