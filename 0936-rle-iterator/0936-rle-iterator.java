class RLEIterator {
    int[] encodingArr;
    int cursor;
    public RLEIterator(int[] encoding) {
        this.encodingArr = new int[encoding.length];
        for(int i = 0;i<encoding.length;i++){
            encodingArr[i] = encoding[i];
        }
        this.cursor = 0;
    }
    
    public int next(int n) {
        while(cursor < encodingArr.length){
            if(encodingArr[cursor] >= n){
                encodingArr[cursor] -= n;
                return encodingArr[cursor+1];
            }else{
                n -= encodingArr[cursor];
                cursor +=2;
            }
        }
        return -1;

    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */