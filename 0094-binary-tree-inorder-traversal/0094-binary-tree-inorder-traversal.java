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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){//if the node has no left subtree it means it is root so inorder is
            //left root right so print root(basically add root)
            ans.add(curr.val);
            curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                //now we have to link the right most node of this left subtree to this root node
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                //if pointing to null means we have to create link now here 
                if(prev.right==null){
prev.right=curr;
curr=curr.left;
                }
                else{//if not null we created already so it is time to delete it 
prev.right=null;
ans.add(curr.val);
curr=curr.right;
                }

            }


        }
        return ans;
    }
}