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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode prev = null;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(level % 2 == 0){
                    if(curr.val % 2 == 0){
                        return false;
                    }

                    if(prev != null && curr.val <= prev.val){
                        return false;
                    }
                }

                else if(level % 2 != 0){
                    if(curr.val % 2 != 0){
                        return false;
                    }

                    if(prev != null && curr.val >= prev.val){
                        return false;
                    }
                }

                prev = curr;

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            level++;
        }

        return true;
    }
}