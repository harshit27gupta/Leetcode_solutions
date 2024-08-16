class Solution {
    public String reverseWords(String s) {
        String[] data = s.split(" ");
        List<String> result = new LinkedList<>();
        for(int i = 0; i < data.length; i++) {
            StringBuilder reverse = new StringBuilder();
            for(int pointer = data[i].length() - 1; pointer >= 0; pointer--) {
                reverse.append(data[i].charAt(pointer));
            }
            result.add(reverse.toString());
        }
                return String.join(" ", result);
    }
}