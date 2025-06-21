import java.util.*;

class LRUCache {
    PriorityQueue<Pair> pq;
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> keyToTime; 
    int size;
    int time;

    public LRUCache(int capacity) {
        pq = new PriorityQueue<>((a, b) -> a.time - b.time); 
        map = new HashMap<>();
        keyToTime = new HashMap<>();
        size = capacity;
        time = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            keyToTime.put(key, time); 
            pq.offer(new Pair(key, val, time));
            time++;
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            if (map.size() >= size) {
                removeLRU();
            }
            map.put(key, value);
        }
        keyToTime.put(key, time); 
        pq.offer(new Pair(key, value, time));
        time++;
    }

    private void removeLRU() {
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            if (map.containsKey(node.key) && keyToTime.get(node.key) == node.time) {
                map.remove(node.key);
                keyToTime.remove(node.key);
                break;
            }
        }
    }

    class Pair {
        int key, value, time;

        public Pair(int key, int value, int time) {
            this.key = key;
            this.value = value;
            this.time = time;
        }
    }
}
