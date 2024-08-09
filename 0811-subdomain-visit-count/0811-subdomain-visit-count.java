class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<cpdomains.length;i++){
            String term=cpdomains[i];
           int ii=0;
           int freq=0;
           while(term.charAt(ii)!=' '){
            freq=freq*10+(term.charAt(ii)-'0');
            ii++;
           }
           String now=term.substring(ii+1);
           String br[]=now.split("\\.");
           int n=br.length;
          for(int idx=n-1;idx>=0;idx--){
            String cc="";
            for(int j=idx;j<n;j++){
                if(j!=idx)
cc+='.';
cc+=br[j];
            }
            map.put(cc,map.getOrDefault(cc,0)+freq);
          } 
        }
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String ss="";
            ss+=entry.getValue()+" "+entry.getKey();
            ans.add(ss);
        }
        return ans;
    }
}