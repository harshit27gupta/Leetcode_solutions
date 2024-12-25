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
    public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
        if(root==null)
    return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int maxi=Integer.MIN_VALUE;
             int level=queue.size();
for(int i=1;i<=level;i++){
    TreeNode val=queue.poll();
maxi=Math.max(maxi,val.val);
if(val.left!=null)
queue.offer(val.left);
if(val.right!=null)
queue.offer(val.right);
}
ans.add(maxi);
        }
        return ans;

    }
}