class Solution {
    public int maximumSwap(int num) {
        HashMap<Integer, Integer> rightMost = new HashMap<>();
        StringBuilder s = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < s.length(); i++) {
            rightMost.put(Character.getNumericValue(s.charAt(i)), i);
        }
        int left = 0;
        while(left < s.length()) {
            int leftval = Character.getNumericValue(s.charAt(left));
            int index = 9;
            while(index > leftval) {
                if(rightMost.containsKey(index) && rightMost.get(index) > left) {
                    s.setCharAt(left, (char)(index + '0'));
                    s.setCharAt(rightMost.get(index), (char)(leftval + '0'));
                    return Integer.valueOf(s.toString());
                }
                index--;
            }
            left++;
        }

        return num;
    }
}