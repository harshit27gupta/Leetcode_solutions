import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    static class segment_info {
   long seg;
   long pref;
   long suf;
   long sum;

    public segment_info(long seg,long pref,long suf,long sum) {
       this.seg=seg;
       this.pref=pref;
       this.suf=suf;
       this.sum=sum;

    }
}
static class segtree{
    int size;
   segment_info seg[];
  
void init(int n){//declaration and initialization of segment tree
    size=1;
    while(size<n)
    size*=2;
    seg=new segment_info[2*size];
    for(int i=0;i<2*size;i++)
    seg[i]=new segment_info(0,0,0,0);
}
segment_info merge(segment_info a,segment_info b){
    return  new segment_info(Math.max(a.seg,Math.max(b.seg,a.suf+b.pref)),Math.max(a.pref,a.sum+b.pref),Math.max(b.suf,a.suf+b.sum),a.sum+b.sum);
}
void update(int i,int v){
    update(i,v,0,0,size);
}
void update(int i,int v,int curr_node,int lx,int rx){// build the segment tree for  min and assign ith value as v and refind min with its count for evry segment and its count
    if((rx-lx)==1){
        if(v>0)
        seg[curr_node]=new segment_info(v,v,v,v);
        else
seg[curr_node]=new segment_info(0,0,0,v);
        return;
        }
        int m=(lx+rx)/2;
        if(i<m)
        update(i,v,2*curr_node+1,lx,m);
        else
        update(i,v,2*curr_node+2,m,rx);
        seg[curr_node]=merge(seg[2*curr_node+1],seg[2*curr_node+2]);

}
segment_info seg_calc(int l,int r){
return seg_calc(l,r,0,0,size);
}
segment_info seg_calc(int l,int r,int curr_node,int lx,int rx)//to find min and min count  in a given range
{
    if(rx<=l||r<=lx)
    return new segment_info(0,0,0,0);
    if(lx>=l && rx<=r)
    return seg[curr_node];
    int m= (lx+rx)/2;
    segment_info min1=seg_calc(l,r,2*curr_node+1,lx,m);
    segment_info min2=seg_calc(l,r,2*curr_node+2,m,rx);
    return  merge(min1,min2);
}
}


public int rangeBitwiseAnd(int left, int right) {//calculate efficiently bitwise and of range(l to r)
    int shift = 0;
  while (left < right) {
      left >>= 1;
      right >>= 1;
      shift++;
  }
  return left << shift;
}
    static int ways(int A[], int t) {
        int[] dp = new int[t + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no coins required for t = 0
        for (int coin : A) {
            for (int i = coin; i <= t; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[t] == Integer.MAX_VALUE ? -1 : dp[t];
    }

    static void swap(int v1, int v2) {
        int tmp=v1;
        v1=v2;
        v2=tmp;
       }
        static void make(int vertex, int[] parent, int[] size) {
               parent[vertex] = vertex;
               size[vertex] = 1;
           }
         static int find(int vertex, int[] parent, int[] size) {
               if (parent[vertex] == vertex)
                   return vertex;
               return parent[vertex] = find(parent[vertex], parent, size);
           }
         static void Union(int vertex1, int vertex2, int[] parent, int[] size) {
             int parent_vertex1 = find(vertex1, parent, size);
             int parent_vertex2 = find(vertex2, parent, size);
             if (parent_vertex1 != parent_vertex2) {
                 if (size[parent_vertex1] < size[parent_vertex2])
                     swap(parent_vertex1,parent_vertex2);
                 parent[parent_vertex2] = parent_vertex1;
                 size[parent_vertex1] += size[parent_vertex2];
             }
         } 
     



    public int minimumDeletions(String word, int k) {
       Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> freqList = new ArrayList<>(freqMap.values());
        Collections.sort(freqList);
        
        int[] cumulativeSum = new int[freqList.size()];
        cumulativeSum[cumulativeSum.length - 1] = freqList.get(freqList.size() - 1);
        for (int i = freqList.size() - 2; i >= 0; i--) {
            cumulativeSum[i] = cumulativeSum[i + 1] + freqList.get(i);
        }
        
        int minDeletions = word.length();
        int sumFreq = 0;
        
        for (int i = 0; i < freqList.size(); i++) {
            int low = i + 1, high = freqList.size() - 1;
            if (freqList.get(freqList.size() - 1) - freqList.get(i) <= k) {
                minDeletions = Math.min(minDeletions, sumFreq);
            } else {
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (freqList.get(mid) - freqList.get(i) <= k) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                int f = 0;
                if (low < freqList.size()) {
                    f = cumulativeSum[low] - (freqList.size() - low) * (freqList.get(i) + k);
                }
                minDeletions = Math.min(minDeletions, f + sumFreq);
            }
            sumFreq += freqList.get(i);
        }
        
        return minDeletions;
    }
}
