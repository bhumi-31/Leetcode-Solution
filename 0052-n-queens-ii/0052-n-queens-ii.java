class Solution {
    public static boolean isSafe(int row, int col, char[][] board, int n){
        for(int i = 0 ;i < row ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        int i = row;
        int j = col;

        while(i >= 0 && j < n){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }

        i = row;
        j = col;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
    public static int solve(int row, char board[][], int n){
        if(row == n){
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board.length; col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                count += solve(row + 1, board, n);
                board[row][col] = '.';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];

        for(int i  = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                board[i][j] = '.';
            }
        }

        return solve(0, board, n);
    }
}