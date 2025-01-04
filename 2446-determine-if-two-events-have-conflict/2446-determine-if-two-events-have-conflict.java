class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String s1= event1[0];
        String e1= event1[1];
        String s2= event2[0];
        String e2=event2[1];
        if(s2.compareTo(e1)<=0 && s1.compareTo(e2)<=0){
            return true;
        }
        return false;
  
        
    }
}