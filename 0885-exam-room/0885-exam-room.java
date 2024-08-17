
class ExamRoom {

    int capacity;
    TreeSet<Integer> seats; 
    
    public ExamRoom(int n) {
        this.capacity=n;
        this.seats = new TreeSet<>();
    }
    
    public int seat() {
        int seatNumber=0;
        if(seats.size() > 0){
            Integer prev=null;
            int distance = seats.first();
            for(Integer seat : seats){
                if(prev != null){
                    int d = (seat-prev)/2;
                    if(distance < d){
                        distance=d;
                        seatNumber=prev+distance;
                    }
                }
                prev = seat;
            }
            
            if(distance < capacity-1-seats.last()){
                seatNumber = capacity-1;
            }
        }
        seats.add(seatNumber);
        return seatNumber;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

