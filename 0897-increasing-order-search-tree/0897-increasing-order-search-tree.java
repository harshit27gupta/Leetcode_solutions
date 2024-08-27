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
    static void ans(TreeNode root,ArrayList<Integer> order){
        if(root==null)
        return ;
        ans(root.left,order);
        order.add(root.val);
        ans(root.right,order);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> order=new ArrayList<>();
        ans(root,order);
        TreeNode head=new TreeNode(order.get(0));
        TreeNode temp=head;
        for(int i=1;i<order.size();i++){
            temp.right=new TreeNode(order.get(i));
            temp.left=null;
            temp=temp.right;
                    }
                    temp.right=null;
                    temp.left=null;
                    return head;
    }
}