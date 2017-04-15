//
public class 139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(breakable[j] && wordDict.contains(s.substring(j, i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}