class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev = new HashSet<>();
        HashSet<Integer> curr;
        HashSet<Integer> result = new HashSet<>();
    
        for (int cv : arr) {
            curr = new HashSet<>();
            curr.add(cv);
            for (int key : prev) {
                curr.add(key | cv);
            }
            prev = curr;
            result.addAll(curr);
        }
        return result.size();
    }
}