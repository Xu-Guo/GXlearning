class Pair{
    String key;
    int value;
    public Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
     
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0 || k == 0){
            return new String[0];
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }
            map.put(s, map.get(s) + 1);
        }
        
        Queue<Pair> q = new PriorityQueue<>(k, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.value != b.value){
                    return a.value - b.value;
                }
                return b.key.compareTo(a.key);
            }
        });
            
        for(String key : map.keySet()){
            Pair p = new Pair(key, map.get(key));
            q.offer(p);
            if(q.size() > k){
                q.poll();
            }
        }
        
        String[] res = new String[k];
        while(!q.isEmpty()){
            res[--k] = q.poll().key;
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