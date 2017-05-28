public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int n  = org.length;
        int[] indegree = new int[n];
        for(int num : org){
            map.put(num, new HashSet<Integer>());
        }
        int count = 0;
        for(int[] seq : seqs){
            count += seq.length;
            if(seq.length > 0 && (seq[0] < 1 || seq[0] > n)){
                return false;
            }
            for(int i = 1; i < seq.length; i++){
                if(seq[i] < 1 ||seq[i] > n){
                    return false;
                }
                if(map.get(seq[i - 1]).add(seq[i])){//seq[i - 1]的child set不包含seq[i]，则加入set
                    indegree[seq[i] - 1]++;
                }
            }
        }
        
        if (count < n){
            return false;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i + 1);
            }
        }
        
        int cnt = 0;
        while(q.size() == 1){//only one pass, 如果每层只有1个选择，则路径唯一
            for(int next : map.get(q.poll())){
                indegree[next - 1]--;
                if(indegree[next - 1] == 0){
                    q.offer(next);
                }
            }
            cnt++;
        }
        return cnt == org.length;
    }
}