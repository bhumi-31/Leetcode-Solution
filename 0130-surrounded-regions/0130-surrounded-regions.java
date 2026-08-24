class Solution {
    public class  Pair{
        int row;
        int col; 
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O'){
                board[0][j] = '#';
                q.add(new Pair(0, j));
            }

            if(board[n-1][j] == 'O'){
                board[n-1][j] = '#';
                q.add(new Pair(n - 1, j));
            }
        }


        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '#';
                q.add(new Pair(i, 0));
            }

            if(board[i][m-1] == 'O'){
                board[i][m-1] = '#';
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

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && board[nrow][ncol] == 'O'){
                    board[nrow][ncol] = '#';
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}