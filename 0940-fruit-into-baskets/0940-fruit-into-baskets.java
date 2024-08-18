class Solution {
    public int totalFruit(int[] fruits) {
    int left = 0, right = 0, max = 0;
    int n = fruits.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    while (right < n) {
        map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
        while (map.size() > 2) {
            int leftKey = fruits[left];
            int leftValue = map.get(leftKey) - 1;
            map.put(leftKey, leftValue);
            if (map.get(leftKey) == 0) {
                map.remove(leftKey);
            }
            left++;
        }
        if(map.size()<=2)max = Math.max(max, right - left + 1);
        right++;
    }
    return max;
    }
}