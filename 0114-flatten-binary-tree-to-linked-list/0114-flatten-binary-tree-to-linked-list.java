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
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> values = new ArrayList<>();
        preorder(root, values);
        TreeNode current = root;
        for (int i = 1; i < values.size(); i++) {
            current.left = null;
            current.right = new TreeNode(values.get(i));
            current = current.right;
        }
    }
    
    public void preorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        preorder(root.left, values);
        preorder(root.right, values);
    }
}