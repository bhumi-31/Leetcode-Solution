class Solution {
    public class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int maxi = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    grid[i][j] = 0;
                    int area = 1;

                    while(!q.isEmpty()){
                        Pair p = q.remove();
                        int r = p.row;
                        int c = p.col;

                        for(int k = 0; k < 4; k++){
                            int nrow = drow[k] + r;
                            int ncol = dcol[k] + c;

                            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                                area += 1;
                                q.add(new Pair(nrow, ncol));
                                grid[nrow][ncol] = 0;
                            }
                        }
                        maxi = Math.max(maxi, area);
                    }
                }
            }
        }
        return maxi;
    }
}