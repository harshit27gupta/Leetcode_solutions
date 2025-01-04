public class Solution{
    public List<Integer> fallingSquares(int[][] positions) {
        TreeSet<Integer> coords = new TreeSet<>();
        for (int[] pos : positions) {
            int left = pos[0];
            int right = pos[0] + pos[1] - 1;
            coords.add(left);
            coords.add(right);
        }
        Map<Integer, Integer> compressed = new HashMap<>();
        int index = 0;
        for (int coord : coords) {
            compressed.put(coord, index++);
        }
        int[] heights = new int[index];
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;
        for (int[] pos : positions) {
            int left = compressed.get(pos[0]);
            int right = compressed.get(pos[0] + pos[1] - 1);
            int currentMaxHeight = 0;
            for (int i = left; i <= right; i++) {
                currentMaxHeight = Math.max(currentMaxHeight, heights[i]);
            }
            int newHeight = currentMaxHeight + pos[1];
            for (int i = left; i <= right; i++) {
                heights[i] = newHeight;
            }

            maxHeight = Math.max(maxHeight, newHeight);
            result.add(maxHeight);
        }

        return result;
    }
}
