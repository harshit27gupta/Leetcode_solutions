class CustomStack {
    int arr[];
    int size;
    int i;

    public CustomStack(int maxSize) {
        size = maxSize;
        arr = new int[size];
        i = 0;
    }

    public void push(int x) {
        if (i < size) { 
            arr[i] = x;
            i++;
        }
    }

    public int pop() {
        if (i == 0) 
            return -1;
        i--;
        return arr[i]; 
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, i); 
        for (int j = 0; j < limit; j++) {
            arr[j] += val;
        }
    }
}
