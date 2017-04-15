public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int step = 1;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String str = q.poll();
                if(str.equals(endWord)){
                    return step;
                }
                for(String s : getAdjWords(str, set)){
                    q.offer(s);
                }
            }
            step++;
        }
        return 0;
    }
    
    private List<String> getAdjWords(String s, Set<String> set){
        List<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char[] cs = s.toCharArray();
            for(char ch='a'; ch<'z'; ch++){
                cs[i] = ch;
                String word = new String(cs);
                if(set.contains(word)){
                    list.add(word);
                    set.remove(word);
                }
            }
        }
        return list;
    }
}