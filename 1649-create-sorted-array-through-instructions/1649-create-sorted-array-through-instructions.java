class Solution {
    public class SegTree{
        private SegTree left,right;
        private int start,end,info;
        public SegTree(int start, int end){
            this.start = start ;
            this.end = end;
            this.info = 0;
            this.left = null;
            this.right = null;
        }
    }
    private void init(SegTree root, int start, int end){
        if(start == end){
            root.info = 0;
            return;
        }
        int mid = (start+end)/2;
        if(root.left==null){
            root.left = new SegTree(start,mid);
            root.right = new SegTree(mid+1,end);
        }
        init(root.left,start,mid);
        init(root.right,mid+1,end);
        root.info = root.left.info + root.right.info;
    }
    private void updateSingle(SegTree root, int index, int val){
        if(index<root.start || root.end<index){
            return;
        }
        if(root.start==root.end){
            root.info = val;
            return ;
        }

        updateSingle(root.left,index,val);
        updateSingle(root.right,index,val);
        root.info = root.left.info + root.right.info;

    }
    private int queryRange(SegTree root, int start, int end){
        if(start>root.end || end<root.start) return 0;
        if(start<=root.start && end>=root.end) return root.info;
       
        return queryRange(root.right,start,end)+queryRange(root.left,start,end);
    }
    public int createSortedArray(int[] instructions) {
        int[] clone = instructions.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> visited = new HashMap<>();
        int index = 0;
        for(int i = 0 ; i<clone.length;i++){
            if(map.containsKey(clone[i])) continue;
            visited.put(clone[i],1);
            map.put(clone[i],index);
            index++;
        }
        SegTree root = new SegTree(0,map.size()-1);
        init(root,0,map.size()-1);
        int res = 0;
        int M = 1000000000+7;

        for(int i = 0 ;  i<clone.length;i++){
            index = map.get(instructions[i]);
            int value = 1;
            if(visited.containsKey(instructions[i])){
                value = visited.get(instructions[i]);
                visited.put(instructions[i],visited.get(instructions[i])+1);
            }
            updateSingle(root,index,value);
            int left = queryRange(root,0,index-1);
            int right = queryRange(root,index+1,map.size()-1);
            res+= Math.min(left,right);
            res%=M;
        }
        return res;
    }
}