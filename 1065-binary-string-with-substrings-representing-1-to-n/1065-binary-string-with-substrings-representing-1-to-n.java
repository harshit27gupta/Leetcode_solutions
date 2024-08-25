class Solution {
    public boolean queryString(String s, int n) {
      Set<Integer> poss=new HashSet<>();
      for(int i=0;i<s.length();i++){
        String st="";
        for(int j=i;j<s.length();j++){
            st+=s.charAt(j);
            if(st.length()>31)
            break;
            if(Integer.parseInt(st,2)<=n && Integer.parseInt(st,2)>=1)
            poss.add(Integer.parseInt(st,2));
        }
      }
      if(poss.size()==n)
      return true;   
      return false;
        
    }
}