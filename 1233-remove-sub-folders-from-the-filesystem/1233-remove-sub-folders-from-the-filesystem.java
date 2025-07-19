class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans =  new ArrayList<>();
        Arrays.sort(folder , (a,b )-> a.compareTo(b));
        for(int i = 0  ; i < folder.length ; i++){
            String first =  folder[i];
            String check = folder[i]+'/';
            while(i+1 < folder.length && folder[i+1].startsWith(check))i++;
            ans.add(first);
        }
        return ans;
    }
}