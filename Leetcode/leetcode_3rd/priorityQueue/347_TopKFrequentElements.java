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