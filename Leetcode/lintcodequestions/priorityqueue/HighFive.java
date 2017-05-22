/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        if(results == null || results.length == 0){
            return res;
        }
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(Record r : results){
            if(!map.containsKey(r.id)){
                map.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = map.get(r.id);
            pq.offer(r.score);
            if(pq.size() > 5){
                pq.poll();
            }
        }
        
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            PriorityQueue<Integer> q = entry.getValue();
            int sum = 0;
            while(!q.isEmpty()){
                sum += q.poll();
            }
            res.put(id, sum / 5.0);
        }
        
        return res;
    }
}