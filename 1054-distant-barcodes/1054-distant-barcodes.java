class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] arr = new int[10001];
        for(int num : barcodes) arr[num]++;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0) pq.add(new int[]{i, arr[i]});
        }
        int index = 0;
        while(!pq.isEmpty()){
            int[] removed = pq.remove();
            int number1 = removed[0];
            int count1 = removed[1];
            barcodes[index] = number1;
            count1--;
            index++;
             int count2 = 0;
            int number2 = 0;
            boolean enter = false;
            if(!pq.isEmpty()){
                int[] removed2 = pq.remove();
                 number2 = removed2[0];
                 count2 = removed2[1];
                barcodes[index] = number2;
                count2--;
                index++;
                enter = true;
            }
            if(count1 > 0) pq.add(new int[]{number1, count1});
            if(enter && count2 > 0) pq.add(new int[]{number2, count2});
        }
        return barcodes;
    }
}