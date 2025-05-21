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
		List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return res;
        }
        helper(root1);
        helper(root2);
        Collections.sort(res);
        return res;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    
}