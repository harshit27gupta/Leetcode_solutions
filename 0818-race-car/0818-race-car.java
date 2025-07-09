class Solution {
    static class State {
        int pos;
        int speed;
        int steps;
        public State(int pos, int speed, int steps) {
            this.pos = pos;
            this.speed = speed;
            this.steps = steps;
        }
    }
    static class PosSpeed {
        int pos;
        int speed;
        public PosSpeed(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PosSpeed that = (PosSpeed) o;
            return pos == that.pos && speed == that.speed;
        }
        @Override
        public int hashCode() {
            return Objects.hash(pos, speed);
        }
    }
    public int racecar(int target) {
        Queue<State> queue = new LinkedList<>();
        Set<PosSpeed> visited = new HashSet<>();
        queue.offer(new State(0, 1, 0));
        visited.add(new PosSpeed(0, 1));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.pos == target) return cur.steps;
            int nextPos = cur.pos + cur.speed;
            int nextSpeed = cur.speed * 2;
            PosSpeed accState = new PosSpeed(nextPos, nextSpeed);
            if (Math.abs(nextPos - target) < target * 2 && !visited.contains(accState)) {
                queue.offer(new State(nextPos, nextSpeed, cur.steps + 1));
                visited.add(accState);
            }
            int revSpeed = cur.speed > 0 ? -1 : 1;
            PosSpeed revState = new PosSpeed(cur.pos, revSpeed);
            if (!visited.contains(revState)) {
                queue.offer(new State(cur.pos, revSpeed, cur.steps + 1));
                visited.add(revState);
            }
        }

        return -1;  
    }
}
