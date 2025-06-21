class LFUCache {

    private int capacity, minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DLList> freqToDLList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToDLList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;

        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() == capacity) {
                DLList minList = freqToDLList.get(minFreq);
                Node toRemove = minList.removeTail();
                keyToNode.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            minFreq = 1;
            keyToNode.put(key, newNode);
            freqToDLList.computeIfAbsent(1, k -> new DLList()).addToHead(newNode);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLList oldList = freqToDLList.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqToDLList.computeIfAbsent(node.freq, k -> new DLList()).addToHead(node);
    }
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node toRemove = tail.prev;
                removeNode(toRemove);
                return toRemove;
            }
            return null;
        }
    }
}
