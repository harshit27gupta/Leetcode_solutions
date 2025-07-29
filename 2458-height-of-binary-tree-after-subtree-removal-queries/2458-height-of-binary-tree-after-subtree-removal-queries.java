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
    static int dfs(TreeNode root) {
        if (root.left != null && root.right != null) {
            siblings[root.left.val] = root.right.val;
            siblings[root.right.val] = root.left.val;
            parent[root.left.val] = root.val;
            parent[root.right.val] = root.val;
            return height[root.val] = Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
        if (root.left != null) {
            parent[root.left.val] = root.val;
            return height[root.val] = dfs(root.left) + 1;
        }
        if (root.right != null) {
            parent[root.right.val] = root.val;
            return height[root.val] = dfs(root.right) + 1;
        }
        return height[root.val] = 0;  
    }

    static int maxN = (int)(1e5);
    static int[] siblings;
    static int[] parent;
    static int[] height;

    public int[] treeQueries(TreeNode root, int[] queries) {
        siblings = new int[maxN + 1];
        Arrays.fill(siblings, -1);
        parent = new int[maxN + 1];
        Arrays.fill(parent, -1);
        height = new int[maxN + 1];

        int maxheight = dfs(root);
        int[] cc = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int bhai = siblings[node];
            int curr = 0;

            if (bhai != -1) {
                curr = height[bhai];
                 curr++;
            }
           

            int parent1 = parent[node];
            while (parent1 != -1) {
                int bro = siblings[parent1]; 
                if (bro != -1 ) {
                    curr = Math.max(curr, height[bro]);
                }
                  curr++;
                parent1 = parent[parent1];
            }
            cc[i] = curr-1;
        }
        return cc;
    }
}
