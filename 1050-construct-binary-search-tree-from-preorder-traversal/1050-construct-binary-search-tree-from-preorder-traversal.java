class Solution {
    public TreeNode create(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = create(root.right, val);
        } else {
            root.left = create(root.left, val);
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = create(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            create(root, preorder[i]);
        }
        return root;
    }
}