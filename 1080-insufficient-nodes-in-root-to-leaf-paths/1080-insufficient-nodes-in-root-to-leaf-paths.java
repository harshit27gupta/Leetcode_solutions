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
   public TreeNode helper(TreeNode root,int limit, int sumTillNow)
    {
        if(root == null)  return null;
        
        if(root.left == null && root.right == null)
             return root.val + sumTillNow < limit ? null : root;
        
        root.left = helper(root.left,limit,sumTillNow + root.val);
        root.right = helper(root.right,limit,sumTillNow + root.val);
        
        return root.left == null && root.right == null ? null : root;
    }
    
    
    public TreeNode sufficientSubset(TreeNode root, int limit){
        return helper(root,limit,0);
    }
}