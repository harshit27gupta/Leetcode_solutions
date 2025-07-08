class Solution {
    // Define business order priority using a static map
    private static Map<String, Integer> businessOrder = new HashMap<>();
    static {
        businessOrder.put("electronics", 0);
        businessOrder.put("grocery", 1);
        businessOrder.put("pharmacy", 2);
        businessOrder.put("restaurant", 3);
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (code[i] != null && !code[i].isEmpty()
                    && code[i].matches("[a-zA-Z0-9_]+")
                    && businessOrder.containsKey(businessLine[i])
                    && isActive[i]) {
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }
        Collections.sort(validCoupons);
        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupons) {
            result.add(c.code);
        }
        return result;
    }
    static class Coupon implements Comparable<Coupon> {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
        @Override
        public int compareTo(Coupon other) {
            int cmp = Integer.compare(businessOrder.get(this.businessLine), businessOrder.get(other.businessLine));
            if (cmp == 0) {
                return this.code.compareTo(other.code);
            }
            return cmp;
        }
    }
}