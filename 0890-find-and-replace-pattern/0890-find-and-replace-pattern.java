class Solution {
    static boolean check(String a,String b){
        HashMap<Character,Character> map=new HashMap<>();
        map.put(a.charAt(0),b.charAt(0));
        for(int i=1;i<a.length();i++){
            if(!map.containsKey(a.charAt(i))){
                if(map.containsValue(b.charAt(i)))
                return false;
                map.put(a.charAt(i),b.charAt(i));
            }
            else{
if(b.charAt(i)!=map.get(a.charAt(i)))
return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(String str:words){
            if(check(str,pattern))
            ans.add(str);
        }
        return ans;
    }
}