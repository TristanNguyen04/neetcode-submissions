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
        in-order: left -> root - right
        1 -> 2 -> 3
    */
    TreeNode result = null;
    int counter = 0;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderTraversal(root);
        return result.val;
    }

    private void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);

        counter++;
        if(counter == k){
            result = root;
            return;
        }

        inOrderTraversal(root.right);
    }
}
