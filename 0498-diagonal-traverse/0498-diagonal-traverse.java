class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0, col = 0;

        int[] ans = new int[n*m];

        for(int i = 0; i < m*n; i++){
            ans[i] = mat[row][col];
            int sum = row + col;
            if(sum % 2 == 0){
                //moving up-right
                if(col == m - 1){
                    row++;
                }else if(row == 0){
                    col++;
                }else{
                    row--;
                    col++;
                }
            }else{
                //moving down-left
                if(row == n - 1){
                    col++;
                }else if(col == 0){
                    row++;
                }else{
                    row++;
                    col--;
                }
            }
        }

        return ans;
    }
}