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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                res.add(curr.val);

                if(curr.right != null){
                    q.add(curr.right);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }
            }
            level++;
            if(level % 2 != 0){
                Collections.reverse(res);
            }
            ans.add(res);
        }

        return ans;
    }
}