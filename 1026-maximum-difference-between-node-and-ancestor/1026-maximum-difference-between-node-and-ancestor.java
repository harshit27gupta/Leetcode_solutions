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
    static void find(TreeNode c,int ans[]){
        if(c==null)
        return;
           ans[0]=Math.min(ans[0],c.val);
            ans[1]=Math.max(ans[1],c.val);
        if(c.left!=null)
            find(c.left,ans);
            if(c.right!=null)
            find(c.right,ans);    
    }
    public int maxAncestorDiff(TreeNode root) {
        int ans[]=new int[2];
        ans[0]=root.val;
        ans[1]=root.val;
        find(root.left,ans);
           int curr=ans[1]-ans[0];
              ans[0]=root.val;
        ans[1]=root.val;
           find(root.right,ans);
           curr=Math.max(curr,ans[1]-ans[0]);
return curr;
    }
}