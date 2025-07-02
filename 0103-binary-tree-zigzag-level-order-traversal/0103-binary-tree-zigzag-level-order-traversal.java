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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int turn=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cc=q.poll();
                temp.add(cc.val);
                if(cc.left!=null)
                q.offer(cc.left);
                if(cc.right!=null)
                q.offer(cc.right);
            }
            if(turn==1)
            Collections.reverse(temp);
            ans.add(temp);
            turn=(turn+1)%2;
        }
        return ans;
    }
}