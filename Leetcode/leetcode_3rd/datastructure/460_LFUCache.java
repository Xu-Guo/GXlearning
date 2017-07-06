public class LFUCache {
    Map<Integer, Integer> map;// K: key, V: value
    Map<Integer, Integer> freqMap;// K: key, V: freq
    Map<Integer, LinkedHashSet<Integer>> freqSets;// K: key, V: LinkedHashSet of all keys with same freq
    int minFreq;
    int cap;
    
    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqSets = new HashMap<>();
        freqSets.put(1, new LinkedHashSet<>());
        cap = capacity;
        minFreq = -1;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        //element exists in the cache, update freq
        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);
        //remove the element from freqSet with old freq
        freqSets.get(freq).remove(key);
        //update minFreq
        if (freq == minFreq && freqSets.get(minFreq).size() == 0){
            //freqSets.remove(minFreq);
            minFreq++;
        }
        //update freqSets
        if (!freqSets.containsKey(freq + 1)){
            freqSets.put(freq + 1, new LinkedHashSet<>());
        }
        freqSets.get(freq + 1).add(key);
        
        //return value
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0){
            return;
        }
        
        //element exists in the cache
        if (map.containsKey(key)){
            //update the value
            map.put(key, value);
            //use get() to update the freq
            get(key);
            return;
        }
        
        //not exists in cache, check capacity first
        if (map.size() >= cap){
            int drop = freqSets.get(minFreq).iterator().next();
            freqSets.get(minFreq).remove(drop);
            map.remove(drop);
        }
        
        //add a new element
        map.put(key, value);
        freqMap.put(key, 1);
        minFreq = 1;
        freqSets.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */