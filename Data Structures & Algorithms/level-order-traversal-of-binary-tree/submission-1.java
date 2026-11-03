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
    /*
        
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int currentSize = queue.size();
            List<Integer> immediate = new ArrayList<>();

            for(int i = currentSize; i > 0; i--){
                TreeNode neighbor = queue.poll();             
                // immediate.add(neighbor.val);

                if(neighbor != null){
                    immediate.add(neighbor.val);
                    queue.offer(neighbor.left);
                    queue.offer(neighbor.right);
                }
            }

            if(immediate.size() > 0) res.add(immediate);
        }

        return res;
    }
}
