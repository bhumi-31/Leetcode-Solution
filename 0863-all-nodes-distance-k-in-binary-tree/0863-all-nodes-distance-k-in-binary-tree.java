/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.left != null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }

            if(curr.right != null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Step1 -> map the parent and child
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);

        //BFS from target value
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()){

            if(distance == k){
                break;
            }

            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.add(curr.left);
                }



                if(curr.right != null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                if(parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))){
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
            distance++;
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}