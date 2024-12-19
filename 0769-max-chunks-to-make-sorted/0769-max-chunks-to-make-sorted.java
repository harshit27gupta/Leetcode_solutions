class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        int[] max = new int[arr.length];
        max[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }

        for(int i=0; i<arr.length; i++) {
            if(max[i] == i) {
                chunk++;
            }
        }
        return chunk;
    }
}