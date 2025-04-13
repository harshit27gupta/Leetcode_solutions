class Solution {
    static final int MOD = 1_000_000_007;

    public int countNumbers(String l, String r, int b) {
        return (countUpTo(r, b) - countUpTo(subtractOne(l), b) + MOD) % MOD;
    }

    private String subtractOne(String num) {
        StringBuilder sb = new StringBuilder(num);
        int i = sb.length() - 1;
        while (i >= 0) {
            if (sb.charAt(i) > '0') {
                sb.setCharAt(i, (char)(sb.charAt(i) - 1));
                break;
            } else {
                sb.setCharAt(i, '9');
                i--;
            }
        }
        if (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

    private int countUpTo(String num, int base) {
        int[] digits = convertToBase(num, base);
        Integer[][][][] dp = new Integer[digits.length + 1][base + 1][2][2];
        return countDP(0, 0, true, true, digits, base, dp);
    }

    private int countDP(int pos, int lastDigit, boolean tight, boolean leadingZero, int[] digits, int base, Integer[][][][] dp) {
        if (pos == digits.length) {
            return leadingZero ? 0 : 1;
        }
        if (dp[pos][lastDigit][tight ? 1 : 0][leadingZero ? 1 : 0] != null) {
            return dp[pos][lastDigit][tight ? 1 : 0][leadingZero ? 1 : 0];
        }

        int limit = tight ? digits[pos] : base - 1;
        int res = 0;
        for (int d = 0; d <= limit; d++) {
            if (!leadingZero && d < lastDigit) continue;
            boolean newTight = tight && (d == limit);
            boolean newLeadingZero = leadingZero && (d == 0);
            res = (res + countDP(pos + 1, newLeadingZero ? 0 : d, newTight, newLeadingZero, digits, base, dp)) % MOD;
        }
        return dp[pos][lastDigit][tight ? 1 : 0][leadingZero ? 1 : 0] = res;
    }

    private int[] convertToBase(String num, int base) {
        java.math.BigInteger n = new java.math.BigInteger(num);
        if (n.equals(java.math.BigInteger.ZERO)) return new int[]{0};
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        while (n.compareTo(java.math.BigInteger.ZERO) > 0) {
            list.add(n.mod(java.math.BigInteger.valueOf(base)).intValue());
            n = n.divide(java.math.BigInteger.valueOf(base));
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(list.size() - 1 - i);
        return result;
    }
}
