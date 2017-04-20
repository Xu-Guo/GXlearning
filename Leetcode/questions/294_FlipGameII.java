public class Solution {
    public boolean canWin(String s) {
        if(s==null || s.length() < 2){
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }
    private boolean helper(String s, Map<String, Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(int i=0; i<s.length()-1; i++){
            if(s.startsWith("++", i)){
                String str = s.substring(0, i) + "--" + s.substring(i+2);
                if(!helper(str, map)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}