import java.util.*;

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int numGroups = groups.length;
        int maxLimit = 100000;
        int[] result = new int[numGroups];
        int[] minElementIndex = new int[maxLimit + 1];
        Arrays.fill(minElementIndex, -1);

        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            if (minElementIndex[element] == -1) {
                minElementIndex[element] = i;
            }
        }
        for (int i = 0; i < numGroups; i++) {
            int bestIndex = Integer.MAX_VALUE;
            int size = groups[i];
            for (int div = 1; div * div <= size; div++) {
                if (size % div == 0) {
                    if (minElementIndex[div] != -1) {
                        bestIndex = Math.min(bestIndex, minElementIndex[div]);
                    }
                    if (minElementIndex[size / div] != -1) {
                        bestIndex = Math.min(bestIndex, minElementIndex[size / div]);
                    }
                }
            }

            result[i] = (bestIndex == Integer.MAX_VALUE) ? -1 : bestIndex;
        }

        return result;
    }
}
