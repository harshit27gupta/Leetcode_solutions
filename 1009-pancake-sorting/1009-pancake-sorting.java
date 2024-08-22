class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        int end = arr.length;
        
        while(end!=1) {
            int index = findIndex(arr, end);  
         flip(arr, index);                
            flip(arr, end-1);                  
            result.add(index+1);                  
            result.add(end);
            end--;
        }
        return result;
    }
    
    private int findIndex(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    private void flip(int[] arr, int index) {
        int start =0;
        while(start<index) {
            int temp = arr[start];
            arr[start] = arr[index];
            arr[index] = temp;
            start++;
            index--;
        }
    }
}