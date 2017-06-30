public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list  = new ArrayList<>();
        
        if (nums == null || nums.length == 0){
            return list;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if (!map.containsKey(n)){
                map.put(n , 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer n : map.keySet()){
            Integer freq = map.get(n);
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--){
            if (bucket[i] != null){
                res.addAll(bucket[i]);
				k -= bucket[i].size();
                if (k == 0){
                    break;
                }
            }
        }
        return res;
        
    }
}


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if (!map.containsKey(n)){
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
                    return entry2.getValue() - entry1.getValue();
                }
            }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        
        List<Integer> list = new ArrayList<>();
        while (list.size() < k){
            Map.Entry<Integer, Integer> entry = pq.poll();
            list.add(entry.getKey());
        }
        return list;
    }
}


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();        
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if (!map.containsKey(n)){
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        
        TreeMap<Integer, List<Integer>> fmap = new TreeMap<>();
        for (Integer n : map.keySet()){
            Integer freq = map.get(n);
            if (!fmap.containsKey(freq)){
                fmap.put(freq, new ArrayList<>());
            }
            fmap.get(freq).add(n);
        }
        List<Integer> list = new ArrayList<>();
        while (list.size() < k){
            Map.Entry<Integer, List<Integer>> entry = fmap.pollLastEntry();
            list.addAll(entry.getValue());
        }
        return list;
    }
}