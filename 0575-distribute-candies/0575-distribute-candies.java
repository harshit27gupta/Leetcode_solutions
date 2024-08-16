class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        int req=n/2;
        Set<Integer> st=new HashSet<>();
        for(int i:candyType)
        st.add(i);
        return Math.min(req,st.size());
    }
}