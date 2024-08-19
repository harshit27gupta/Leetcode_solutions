class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String log : logs) {
            if(isDigitLog(log)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs, (log1, log2) -> {
            int idx1 = log1.indexOf(' ');
            int idx2 = log2.indexOf(' ');

            String content1 = log1.substring(idx1+1);
            String content2 = log2.substring(idx2+1);
            int compareContent = content1.compareTo(content2);
            if(compareContent != 0) {
                return compareContent;
            }
            return log1.substring(0, idx1).compareTo(log2.substring(0, idx2));
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

    boolean isDigitLog(String log) {
        int firstSpace = log.indexOf(' ');
        String identifier = log.substring(0, firstSpace);
        String content = log.substring(firstSpace+1);

        int firstDigit = content.charAt(0) - '0';
        return firstDigit >= 0 && firstDigit < 10;
    }
}