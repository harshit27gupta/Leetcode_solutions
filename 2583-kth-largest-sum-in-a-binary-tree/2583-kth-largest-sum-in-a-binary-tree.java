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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            long sum=0;
            for(int i=1;i<=size;i++){
                TreeNode res=queue.poll();
                sum+=res.val;
                if(res.left!=null)
                queue.offer(res.left);
                if(res.right!=null)
                queue.offer(res.right);
            }
            pq.offer(sum);
            if(pq.size()>k)
            pq.poll();
        }
         return pq.size() < k ? -1 : pq.peek();
    }
}