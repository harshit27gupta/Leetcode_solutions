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

    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } 
        List<TreeNode> result = new ArrayList<>();
        if(n > 0) {
            if(n == 1) {
            result.add(new TreeNode(0));
            } else if(n == 3){
                TreeNode root =  new TreeNode(0, new TreeNode(0), new TreeNode(0));
                result.add(root); 
            } else {
                    for(int i = 1; i <n; i++) {
                        List<TreeNode> left = allPossibleFBT(i);
                        List<TreeNode> right = allPossibleFBT(n-i-1);

                        for(TreeNode leftNode : left) {
                            for(TreeNode rightNode : right) {
                                result.add(new TreeNode(0, leftNode, rightNode));
                            }
                        }
                    }
            }
            map.put(n, result);
        }
        return result;
    }
}