public class ValidWordAbbr {
    Map<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String word : dictionary){
            String abbr = getAbbr(word);
            if(!map.containsKey(abbr)){
                map.put(abbr, word);
            }else{
                if(!map.get(abbr).equals(word)){
                    map.put(abbr, "");
                }
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    
    private String getAbbr(String word){
        if(word.length()<=2){
            return word;
        }
        int len = word.length();
        String abb = "";
        return abb + word.charAt(0) + (len-2) + word.charAt(len-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */