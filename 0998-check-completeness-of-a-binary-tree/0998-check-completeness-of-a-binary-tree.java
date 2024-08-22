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
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list=bfs(root);
        if(root==null) return false;
        boolean bool=true;
        for(int i=list.size()-1; i>=0; i--){
            if(bool && list.get(i)==null){
                list.remove(i);
                continue;
            }
            else bool=false;
            if(list.get(i)==null) return false;
        }
        return true;
         
    }
    public List<TreeNode> bfs(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<TreeNode> list=new ArrayList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null) continue;
            list.add(node.left);
            list.add(node.right);
            queue.add(node.left);
            queue.add(node.right);
        }
        return list;
    }
}