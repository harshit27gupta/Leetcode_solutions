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
    static int h(TreeNode root){
        if(root==null)
        return 0;
        int left=h(root.left);
        int right=h(root.right);
        if(left==-1 ||  right==-1)
        return -1;
        if(Math.abs(left-right)>1)
        return -1;
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return (h(root)==-1?false:true);
    }
}