class Solution {
    public class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];

        Queue<Pair> q = new LinkedList<>();

        if(originalColor == color){
            return image;
        }

        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();


            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == originalColor){
                    image[nrow][ncol] = color;
                    q.add(new Pair(nrow, ncol));
                } 
            }
        }
        return image;
    }
}