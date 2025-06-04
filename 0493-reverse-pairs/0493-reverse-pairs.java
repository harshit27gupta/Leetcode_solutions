class Solution {
    static int ans = 0;
    static void merge(int nums[], int l, int mid, int high) {
        int i = l;
        int j = mid + 1;
        int countJ = mid + 1;
        for (int a = l; a <= mid; a++) {
            while (countJ <= high && (long) nums[a] > 2L * nums[countJ]) {
                countJ++;
            }
            ans += (countJ - (mid + 1));
        }
        int tmp[] = new int[high - l + 1];
        int k = 0;
        i = l;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= high) tmp[k++] = nums[j++];
        for (int p = 0; p < tmp.length; p++) {
            nums[l + p] = tmp[p];
        }
    }

    static void mergesort(int nums[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergesort(nums, l, mid);
            mergesort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public int reversePairs(int[] nums) {
        ans = 0;
        mergesort(nums, 0, nums.length - 1);
        return ans;
    }
}
