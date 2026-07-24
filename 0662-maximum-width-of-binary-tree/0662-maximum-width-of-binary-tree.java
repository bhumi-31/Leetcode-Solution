/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int idx;

        public Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().idx;
            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int currIdx = curr.idx - min;

                TreeNode node = curr.node;

                if(i == 0) first = currIdx;
                if(i == size - 1) last = currIdx;

                if(node.left != null){
                    q.add(new Pair(node.left, 2 * currIdx + 1));
                }

                if(node.right != null){
                    q.add(new Pair(node.right, 2 * currIdx + 2));
                }

            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}