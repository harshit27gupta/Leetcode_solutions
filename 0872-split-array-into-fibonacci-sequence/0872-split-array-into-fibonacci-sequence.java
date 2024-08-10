class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new LinkedList<>();
        Boolean[][][] vis = new Boolean[num.length()][num.length()][num.length()];

        long n1 = 0, n2 = 0;
        for(int i = 0; i < num.length(); i++){
            n1 = n1 * 10 + (num.charAt(i) - '0');
            if(n1 > Integer.MAX_VALUE){
                break;
            }
            n2 = 0;
            for(int j = i + 1; j < num.length(); j++){
                n2 = n2 * 10 + (num.charAt(j) - '0');
                if(n2 > Integer.MAX_VALUE){
                    break;
                }
                
                if(getFib(j + 1, 0, i + 1, n1, n2, num, vis, res) && res.size() > 0){
                    res.add(0, (int)n2);
                    res.add(0, (int)n1);
                    return res;
                }
                if(j == i + 1 && num.charAt(j) == '0'){
                    break;
                }
            }
            if(num.charAt(0) == '0'){
                break;
            }
        }
        return res;
    }

    public boolean getFib(int i, int j, int k, long n1, long n2, String num, Boolean[][][] vis, List<Integer> res){
        if(i == num.length()){
            return true;
        }
        if(vis[j][k][i] != null){
            return vis[j][k][i];
        }
        if(num.charAt(i) == '0'){
            if(n1 + n2 != 0){
                return false;
            }
            if(getFib(i + 1, k, i, n2, 0, num, vis, res)){
                res.add(0, 0);
                return true;
            }
            return false;
        }
        
        long val = 0;
        for(int l = i; l < num.length(); l++){
            val = val * 10 + (num.charAt(l) - '0');
            if(val > Integer.MAX_VALUE){
                break;
            }
            
            if(n1 + n2 < val){
                break;
            }
            
            if(n1 + n2 == val){
                if(getFib(l + 1, k, i, n2, val, num, vis, res)){
                    res.add(0, (int)val);
                    return true;
                }
                
            }
        }
        vis[j][k][i] = false;
        return false;
    }
}