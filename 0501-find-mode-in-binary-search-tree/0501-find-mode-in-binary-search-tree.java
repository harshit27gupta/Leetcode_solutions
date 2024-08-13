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
import java.util.*;

public class Solution {
    private HashMap<Integer, Integer> valueCount = new HashMap<>();
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }


        inorderTraversal(root);


        List<Integer> modesList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                modesList.add(entry.getKey());
            }
        }

        int[] modesArray = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modesArray[i] = modesList.get(i);
        }

        return modesArray;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        int currentValue = node.val;
        int currentCount = valueCount.getOrDefault(currentValue, 0) + 1;
        valueCount.put(currentValue, currentCount);
        maxCount = Math.max(maxCount, currentCount);

        inorderTraversal(node.right);
    }
}