class Solution {
    public List<Integer>result = new ArrayList<>();
    public void helper(int n,int curr){
        if(curr > n)
            return;
        result.add(curr);
        helper(n,curr*10);
        if(curr%10 != 9)
            helper(n,curr+1);
    }
    public List<Integer> lexicalOrder(int n) {
        helper(n,1);
        return result;
    }
}