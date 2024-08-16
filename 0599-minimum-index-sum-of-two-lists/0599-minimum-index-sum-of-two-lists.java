class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map=new HashMap<>();
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
if(list1[i].equals(list2[j])){
    map.put(list1[i],i+j);
    mini=Math.min(mini,i+j);
}
            }
        }
            List<String> an=new ArrayList<>();
          for (Map.Entry<String, Integer> entry : map.entrySet()){
if(entry.getValue()==mini)
an.add(entry.getKey());
          }
          String ans[]=new String[an.size()];
          int i=0;
          for(String ar:an)
          ans[i++]=ar;
          return  ans;
    }
}