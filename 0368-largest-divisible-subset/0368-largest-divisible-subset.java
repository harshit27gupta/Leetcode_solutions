class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
            int n = arr.length;

        // Sort the array
    Arrays.sort(arr);

        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            hash.set(i, i); // Initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (arr[i] % arr[prev_index] == 0 && 1 + dp.get(prev_index) > dp.get(i)) {
                    dp.set(i, 1 + dp.get(prev_index));
                    hash.set(i, prev_index);
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp.get(i) > ans) {
                ans = dp.get(i);
                lastIndex = i;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash.get(lastIndex) != lastIndex) {
            lastIndex = hash.get(lastIndex);
            temp.add(arr[lastIndex]);
        }

        // Reverse the array
        Collections.reverse(temp);

        return temp;
    }
}


        // Write your code here.
     
    
