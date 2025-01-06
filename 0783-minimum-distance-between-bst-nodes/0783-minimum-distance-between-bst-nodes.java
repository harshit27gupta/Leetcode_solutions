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
    static void dfs( ArrayList<Integer> nodes,TreeNode root){
        if(root==null)
        return ;
        nodes.add(root.val);
        dfs(nodes,root.left);
        dfs(nodes,root.right);
    }
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> nodes=new ArrayList<>();
         dfs(nodes,root);
         Collections.sort(nodes);
         int ans=Integer.MAX_VALUE;
         for(int i=1;i<nodes.size();i++)
         ans=Math.min(ans,nodes.get(i)-nodes.get(i-1));
         return ans;
    }
}