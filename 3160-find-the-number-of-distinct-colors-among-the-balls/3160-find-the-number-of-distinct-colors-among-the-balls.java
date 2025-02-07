class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int len=queries.length;
        Map<Integer,Integer> nm=new HashMap<>();
        Map<Integer,Integer> kk=new HashMap<>();
        int ans[]=new int[len];
        for(int i=0;i<len;i++)
        {
            int val1=queries[i][0];
            int val2=queries[i][1];
            if(nm.containsKey(val1))
            {
                if(kk.get(nm.get(val1)) == 1)
                {
                    kk.remove(nm.get(val1));
                }
                else
                {
                    kk.put(nm.get(val1), kk.get(nm.get(val1))-1);
                }
                nm.remove(val1);
            }
            nm.put(val1,val2);
            kk.put(val2, kk.getOrDefault(val2,0)+1);
            // System.out.println(nm);
            // System.out.println(kk);
            ans[i]=kk.size();
        }
        return ans;
    }
}