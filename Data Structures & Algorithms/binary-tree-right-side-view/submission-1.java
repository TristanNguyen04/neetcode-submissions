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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        queue.addLast(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            result.add(queue.getLast().val);

            for(int i = 0; i < queueSize; i++){
                TreeNode current = queue.pollFirst();

                if(current.left != null){
                    queue.addLast(current.left);
                }

                if(current.right != null){
                    queue.addLast(current.right);
                }
            }
        }

        return result;
    }
}
