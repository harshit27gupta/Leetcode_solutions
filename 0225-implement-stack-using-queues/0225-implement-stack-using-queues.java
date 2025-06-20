class MyStack {
    Deque<Integer> queue;
    
    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offerLast(x); 
    }
    
    public int pop() {
        if (queue.isEmpty()) return -1;
        return queue.pollLast();  
    }
    
    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peekLast();  
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */