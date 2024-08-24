class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        long s = 0;
        for (int i : arr) {
            s += i;
        }
        if (s % 3 != 0) {
            return false;
        }
        
        long target = s / 3;
        long sum = 0;
        int count = 0;    
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                count++;
                sum = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
