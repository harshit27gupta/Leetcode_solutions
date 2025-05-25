class Solution {
    public int maxSubstrings(String word) {
        HashMap<Character,Integer > map=new HashMap<>();
        int cnt=0;
        int len=0;
        int idx=0;
        for(char c:word.toCharArray()){
            if(map.containsKey(c) && (idx-map.get(c)+1)>=3){
                cnt++;
                map.clear();
                len=0;
            }
            else{
            map.put(c,idx);
            idx++;
            }
        }
        return cnt;
    }
}