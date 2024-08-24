class Solution {
    public int findMax(int[] nums, int l, int r) {
        int maxIdx = l;
        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public TreeNode helper(int l, int r, int[] nums) {
        if (l > r) return null;
        int maxIdx = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = helper(l, maxIdx - 1, nums);
        root.right = helper(maxIdx + 1, r, nums);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }
}