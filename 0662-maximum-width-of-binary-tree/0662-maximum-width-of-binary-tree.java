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
    static class pair{
        TreeNode a;
        int val;
        public pair(TreeNode a,int val){
            this.a=a;
            this.val=val;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        Queue<pair> q=new LinkedList<>();
        int ans=0;
        q.offer(new pair(root,1));
        while(!q.isEmpty()){
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            int sz=q.size();
            for(int i=0;i<sz;i++){
pair cc=q.poll();
if(cc.a.left!=null)
q.offer(new pair(cc.a.left,cc.val*2));
if(cc.a.right!=null)
q.offer(new pair(cc.a.right,cc.val*2+1));
max=Math.max(max,cc.val);
min=Math.min(min,cc.val);
            }
            ans=Math.max(ans,max-min+1);
        }
        return ans;
    }
}