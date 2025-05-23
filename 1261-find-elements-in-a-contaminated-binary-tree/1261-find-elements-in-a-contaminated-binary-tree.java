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
class FindElements {
    static TreeNode root; 
    static Set<Integer> set; 
    public FindElements(TreeNode root) {
        set = new HashSet<>(); 
        traversal(root , 0);  
    }
    static void traversal(TreeNode root, int val){
        if(root != null){
            set.add(val); 
            traversal(root.left , 2 * val + 1); 
            traversal(root.right , 2 * val + 2); 
        }
    }
    
    public boolean find(int target) {
        return set.contains(target); 
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */