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

