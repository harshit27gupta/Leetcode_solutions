import java.util.*;

class NumberContainers {
     Map<Integer, Integer> map1; 
    TreeMap<Integer, TreeSet<Integer>> map2; 

    public NumberContainers() {
        map1 = new HashMap<>();
        map2 = new TreeMap<>();
    }
    public void change(int index, int number) {
        if (map1.containsKey(index)) {
            int oldNumber = map1.get(index);
            if (oldNumber != number) {
                map2.get(oldNumber).remove(index);
                if (map2.get(oldNumber).isEmpty()) {
                    map2.remove(oldNumber);
                }
            }
        }
        map1.put(index, number);
        map2.putIfAbsent(number, new TreeSet<>());
        map2.get(number).add(index);
    }

    public int find(int number) {
        if (!map2.containsKey(number) || map2.get(number).isEmpty()) {
            return -1;
        }
        return map2.get(number).first(); 
    }
}

/**
 * Example Usage:
 * NumberContainers obj = new NumberContainers();
 * obj.change(1, 10);
 * obj.change(2, 10);
 * obj.change(3, 20);
 * System.out.println(obj.find(10)); // Output: 1
 * obj.change(1, 20);
 * System.out.println(obj.find(10)); // Output: 2
 */
