class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> st1=new HashSet<>();
        Set<String> st2=new HashSet<>();
        HashMap<String,Integer> map1=new HashMap<>();
                HashMap<String,Integer> map2=new HashMap<>();

        for(String c:s1.split(" ")){
          map1.put(c,map1.getOrDefault(c,0)+1);
        st1.add(c);
        }
              for(String c:s2.split(" ")){
                  map2.put(c,map2.getOrDefault(c,0)+1);
        st2.add(c);
              }
              
        List<String> ans=new ArrayList<>();
        for(String c:st1){
            if(!(st2.contains(c)) && map1.get(c)==1)
            ans.add(c);
        }
          for(String c:st2){
            if(!(st1.contains(c)) && map2.get(c)==1)
            ans.add(c);
        }
        String res[]=new String[ans.size()];
        int i=0;
        for(String c:ans){
            res[i]=c;
            i++;
        }
        return res;


    }
}