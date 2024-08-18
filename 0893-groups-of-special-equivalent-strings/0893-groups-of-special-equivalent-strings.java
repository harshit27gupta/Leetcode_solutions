class Solution {
    static boolean check(String a,String b){
        ArrayList<Character> s1=new ArrayList<>();
             ArrayList<Character> s11=new ArrayList<>();
                  ArrayList<Character> s2=new ArrayList<>();
             ArrayList<Character> s22=new ArrayList<>();
             for(int i=0;i<a.length();i++){
                if(i%2==0){
                    s1.add(a.charAt(i));
                    s2.add(b.charAt(i));
                }
                else{
                      s11.add(a.charAt(i));
                    s22.add(b.charAt(i));
                }
             }
             Collections.sort(s1);
               Collections.sort(s2);
                 Collections.sort(s11);
                   Collections.sort(s22);
                   for(int i=0;i<s1.size();i++){
                    if(s1.get(i)!=s2.get(i))
                    return false;
                   }
                   for(int i=0;i<s11.size();i++){
                    if(s11.get(i)!=s22.get(i))
                    return false;
                   }
                   return true;
    }
    public int numSpecialEquivGroups(String[] words) {
        int grps=0;
        boolean visited[]=new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(visited[i])
            continue;
            grps++;
            for(int j=i+1;j<words.length;j++){
                if(visited[j])
                continue;
if(check(words[i],words[j]))
visited[j]=true;
            }

        }
        return grps;
    }
}