class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSoFar = 0;
        int bestSoFar = values[0] + 0;

        for(int j = 1; j < values.length; j++){
            maxSoFar = Math.max(maxSoFar, bestSoFar + values[j] - j);
            bestSoFar = Math.max(bestSoFar, values[j] + j);
        }
        
        return maxSoFar;
    }
}