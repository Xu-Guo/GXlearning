public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0){
            return 0;
        }
        
        wordList.add(beginWord);

        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        
        Set<String> visited = new HashSet<>();
        int steps = 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()){
            steps++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String current = q.poll();
                for (String child : getChildren(current, dict)){
                    if (child.equals(endWord)){
                        return steps + 1;
                    }
                    if (!visited.contains(child)){
                        q.offer(child);
                        visited.add(child);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getChildren(String s, Set<String> dict){
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
}