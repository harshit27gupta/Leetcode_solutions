class MyHashSet {
ArrayList<Integer> set;
    public MyHashSet() {
        set=new ArrayList<>();
    }
    
    public void add(int key) {
        if(set.indexOf(key)>=0)
        return;
        set.add(key);
    }
    
    public void remove(int key) {
        if(set.indexOf(key)<0)
        return ;
        set.remove(set.indexOf(key));
    }
    
    public boolean contains(int key) {
        if(set.indexOf(key)>=0)
        return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */