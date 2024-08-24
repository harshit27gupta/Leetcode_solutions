class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = map.getOrDefault(key, new TreeMap<>());
        values.put(timestamp, value);
        map.put(key, values);
    }
    
    public String get(String key, int timestamp) {
       TreeMap<Integer, String> values = map.get(key);
       if(values == null || values.size()==0) return "";
       Integer lastKey = values.floorKey(timestamp);
       return lastKey == null ? "" : values.get(lastKey); 
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */