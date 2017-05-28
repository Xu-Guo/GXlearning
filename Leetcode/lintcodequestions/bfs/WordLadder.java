public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null || dict.size() == 0){
            return 0;
        }
        if(start.equals(end)){
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        set.add(start);
        
        int length = 1;
        while(!q.isEmpty()){
            length++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                for(String next : getNextWords(word, dict)){
                    if(set.contains(next)){
                        continue;
                    }
                    if(next.equals(end)){
                        return length;
                    }
                    q.offer(next);
                    set.add(next);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> dict){
        List<String> nextWords = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            char[] cs = null;
            for(char c = 'a'; c <= 'z'; c++){
                cs = word.toCharArray();
                cs[i] = c;
                String next = new String(cs);
                if(dict.contains(next)){
                    nextWords.add(next);
                }
            }
        }
        return nextWords;
    }
}