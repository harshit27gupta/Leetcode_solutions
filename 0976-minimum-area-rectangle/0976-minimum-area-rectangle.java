class Solution {
    public int minAreaRect(int[][] points) {
        int maxArea = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> m = new HashMap<>();
        for(int i[]: points){
            if(!m.containsKey(i[0]))     m.put(i[0], new HashSet<>());
            m.get(i[0]).add(i[1]);
        }
        for(int i[]: points){
            for(int j[]: points)
                if(i[0] < j[0] && i[1] < j[1] && m.get(j[0]).contains(i[1]) && m.get(i[0]).contains(j[1]))
                    maxArea = Math.min(maxArea, (j[0] - i[0]) *(j[1] - i[1]));
        }
        return maxArea == Integer.MAX_VALUE? 0 : maxArea;
    }
}