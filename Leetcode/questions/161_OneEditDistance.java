public class 161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        
        if(s.length() == t.length()){
            return isModified(s, t);
        }
        
        if(s.length() > t.length()){
            return isDeleted(s, t);
        }else{
            return isDeleted(t, s);
        }
    }
    
    private boolean isModified(String s, String t){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
    
    private boolean isDeleted(String ls, String ss){
        for(int i=0; i<ss.length(); i++){
            if(ls.charAt(i) != ss.charAt(i)){
                return ls.substring(i+1).equals(ss.substring(i));
            }
        }
        return true;
    }
}