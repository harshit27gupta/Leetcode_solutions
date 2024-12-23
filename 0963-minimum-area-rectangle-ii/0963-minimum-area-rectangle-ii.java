class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                double midX = (p1[0] + p2[0]) / 2.0;
                double midY = (p1[1] + p2[1]) / 2.0;
                double distSq = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
                String key = midX + "," + midY + "," + distSq;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        double min = Double.MAX_VALUE;
        for (List<int[]> pairs : map.values()) {
            for (int i = 0; i < pairs.size(); i++) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    int[] pair1 = pairs.get(i);
                    int[] pair2 = pairs.get(j);       
                    int[] p1 = points[pair1[0]];
                    int[] p2 = points[pair1[1]];
                    int[] p3 = points[pair2[0]];
                    int[] p4 = points[pair2[1]];
                    double area = Math.sqrt(Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2)) *
                                  Math.sqrt(Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2));
                    
                    min = Math.min(min, area);
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }
}