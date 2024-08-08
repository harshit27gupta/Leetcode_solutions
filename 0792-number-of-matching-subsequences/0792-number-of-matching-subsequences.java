class Solution {
    static boolean findmatch(String str,String s){
        int i=0;
        int j=0;
        while(i<str.length() && j<s.length()){
if(str.charAt(i)==s.charAt(j)){
    i++;
    j++;
}
else
i++;
        }
        return (j==s.length());
    }
    public int numMatchingSubseq(String s, String[] words) {
   HashMap<String,Integer> map=new HashMap<>();
   for(String st:words)
   map.put(st,map.getOrDefault(st,0)+1);
   int ans=0;
   for(Map.Entry<String,Integer> entry:map.entrySet()){
String comp=entry.getKey();
ans+=(findmatch(s,comp)?entry.getValue():0);
   }
   return ans;
    }
}