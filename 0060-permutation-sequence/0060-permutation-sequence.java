class Solution {
    public String getPermutation(int n, int k) {
        // Initialize factorial for (n-1)!
        int fact = 1;

        // List to store numbers from 1 to n
        List<Integer> numbers = new ArrayList<>();

        // Precompute factorial of (n - 1) and populate list with 1 to (n - 1)
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }

        // Add the last number n
        numbers.add(n);

        // String to store the final kth permutation
        String ans = "";

        // Decrement k to convert from 1-based to 0-based indexing
        k = k - 1;

        // Loop until all digits are used
        while (true) {
            // Get the index of current digit to be used
            int index = k / fact;

            // Append the digit at index to the answer
            ans = ans + numbers.get(index);

            // Remove the used digit from the list
            numbers.remove(index);

            // If no digits left, we're done
            if (numbers.size() == 0) {
                break;
            }

            // Update k to the remainder for the next position
            k = k % fact;

            // Update fact to reflect remaining digits
            fact = fact / numbers.size();
        }

        // Return the final permutation string
        return ans;
    }
}
