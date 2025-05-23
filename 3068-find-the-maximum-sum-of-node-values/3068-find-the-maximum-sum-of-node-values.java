import java.util.*;

class Solution {
    //hello its me i am under water please help me,,i am drowning ,,,this is my accepted code ,,pls accept thiss as my little offering..
      static int justsmall(ArrayList<Long> A,long x){//maximum index of element just <=x
            long l=-1;
            long r=A.size();
            while(l<r-1){
                long mid=(l+r)/2;
                if(x>=A.get((int)mid))
                l=mid;
                else
                r=mid;
            }
            return (int)(l+1);
        }
         static int justgreat(Integer A[],int x){//minimum index of element just >=x
            int left = 0;
            int right = A.length - 1;
            int result = A.length ;
     
            while (left <= right) {
                int mid = left + (right - left) / 2;
     
                if (A[mid] >=x) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
     
            return result + 1;
        }
        static int justgreat(ArrayList<Integer> A,int x){//minimum index of element just >=x
            int left = 0;
            int right = A.size() - 1;
            int result = A.size();
     
            while (left <= right) {
                int mid = left + (right - left) / 2;
     
                if (A.get(mid)>=x) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
     
            return result + 1;
        }
        static long maxlength(long arr[],int n,long s){// to find segment of array of maximum length having sum atmost s
            long  sum = 0, mx = 0;
            long r=0,l=0;
                while (r < n) {
                    sum += arr[(int)r];
                    if (sum <= s) {
                        mx = Math.max(mx, r - l + 1);
                    } else {
                        while (l < r && sum > s) {
                            sum -= arr[(int)l];
                            l++;
                        }
                        if (sum <= s) {
                            mx = Math.max(mx, r - l + 1);
                        }
                    }
                    r++;
                }
         return mx;
            }
    
    private void buildGraph(int edges[][], List<Integer>[] g) {
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
    }
    
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<Integer>[] lis = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lis[i] = new ArrayList<>();
        }
       buildGraph(edges,lis);
        List<Integer> inc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long val = (long) nums[i] ^ k;
            if (val > nums[i]) {
                inc.add(i);
            }
        }
        int size = inc.size();
        if (size % 2 == 0) {
            long ans = 0;
            for (int num : nums) {
                ans += num;
            }
            for (int i : inc) {
                ans -= nums[i];
                long add = (long) nums[i] ^ k;
                ans += add;
            }
            return ans;
        } else {
            long ans = 0;
            for (int num : nums) {
                ans += num;
            }
            long wow = ans;
            for (int i : inc) {
                ans -= nums[i];
                long add = (long) nums[i] ^ k;
                ans += add;
            }
            for (int i = 0; i < size; i++) {
                long curr = (long) nums[inc.get(i)] ^ k;
                long currAns = ans - curr + nums[inc.get(i)];
                wow = Math.max(wow, currAns);
            }
            boolean[] visited = new boolean[n];
            for (int i : inc) {
                visited[i] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    long curr = (long) nums[i] ^ k;
                    long currAns = ans - nums[i] + curr;
                    wow = Math.max(wow, currAns);
                }
            }
            return wow;
        }
    }
}
