class Solution {
    public class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1){
                grid[0][j] = '#';
                q.add(new Pair(0,j));
            }

            if(grid[n-1][j] == 1){
                grid[n-1][j] = '#';
                q.add(new Pair(n-1, j));
            }
        }

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1){
                grid[i][0] = '#';
                q.add(new Pair(i, 0));
            }

            if(grid[i][m-1] == 1){
                grid[i][m-1] = '#';
                q.add(new Pair(i, m - 1));
            } 
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = '#';
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
}