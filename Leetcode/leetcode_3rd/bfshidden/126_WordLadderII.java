public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
           Set<String> dict = new HashSet<>(wordList);
           List<List<String>> res = new ArrayList<>();         
           Map<String, List<String>> neighbors = new HashMap<>();// Neighbors for every node
           Map<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
           List<String> list = new ArrayList<>();
        
           dict.add(beginWord);          
           bfs(beginWord, endWord, dict, neighbors, distance);                 
           dfs(beginWord, endWord, dict, neighbors, distance, list, res);   
           return res;
    }
    
    private void bfs (String start, String end, Set<String> dict, Map<String, List<String>> neighbors, Map<String, Integer> distance){
        for (String str : dict){
            neighbors.put(str, new ArrayList<>());
        }
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        
        while (!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                int curDistance = distance.get(cur);
                List<String> nbs = getNeighbors(cur, dict);
                for (String nb : nbs){
                    neighbors.get(cur).add(nb);
                    if (!distance.containsKey(nb)){
                        distance.put(nb, curDistance + 1);
                        if (nb.equals(end)){
                            found = true;
                        } else {
                            q.offer(nb);
                        }
                    }
                }
            }
            if (found){
                break;
            }
        }
    }
    
    private List<String> getNeighbors(String s, Set<String> dict){
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0){
            return list;
        }
        for (int i = 0; i < s.length(); i++){
            char[] cs = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++){
                cs[i] = c;
                String newStr = new String(cs);
                if (dict.contains(newStr)){
                    list.add(newStr);
                }
            }
        }
        return list;
    }
    
    private void dfs (  String cur, 
                        String end, 
                        Set<String> dict, 
                        Map<String, List<String>> neighbors, 
                        Map<String, Integer> distance, 
                        List<String> list, 
                        List<List<String>> res){
        list.add(cur);
        if (cur.equals(end)){
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);   
            return;
        }
        
        for (String next : neighbors.get(cur)){
            if (distance.get(next) == distance.get(cur) + 1){
                dfs(next, end, dict, neighbors, distance, list, res);
            }
        }
        list.remove(list.size() - 1);
    }

}