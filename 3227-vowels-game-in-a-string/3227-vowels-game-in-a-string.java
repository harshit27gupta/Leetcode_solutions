class Solution {
    public boolean doesAliceWin(String s) {
          Set<Character> vo= new HashSet<>();
        vo.add('a');
        vo.add('e');
        vo.add('i');
        vo.add('o');
        vo.add('u');
        for (char c : s.toCharArray()) {
            if (vo.contains(c)) {
                return true;
            }
        }
        return false;
    }
}