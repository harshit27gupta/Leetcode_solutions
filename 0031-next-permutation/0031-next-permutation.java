class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first index 'i' such that nums[i] < nums[i+1] from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such index is found, find the index 'j' to swap with
        if (i >= 0) {
            int j = n - 1;

            // Find the next greater element than nums[i] from the end
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap the elements at i and j
            swap(nums, i, j);
        }

        // Step 3: Reverse the subarray from i+1 to end to get the next smallest lexicographic order
        reverse(nums, i + 1, n - 1);
    }

    // Utility to swap elements at two indices
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Utility to reverse elements from index i to j
    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
