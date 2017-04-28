public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        if(dict == null || dict.size() == 0){
            return s.length();
        }
        
        Queue<String> q = new LinkedList<String>();
        Set<String> set = new HashSet<>();
        
        int min = s.length();
        q.offer(s);
        set.add(s);
        while(!q.isEmpty()){
            String str = q.poll();
            for(String sub : dict){
                int found = str.indexOf(sub);
                while(found != -1){
                    String new_str = str.substring(0, found) + str.substring(found + sub.length(), str.length());
                    if(!set.contains(new_str)){
                        if(new_str.length() < min){
                            min = new_str.length();
                        }
                        q.offer(new_str);
                        set.add(new_str);
                    }
                    //从上次找到的地方开始继续找，下次循环会保留本次的sub，删除第2个找到的sub
                    found = str.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
}