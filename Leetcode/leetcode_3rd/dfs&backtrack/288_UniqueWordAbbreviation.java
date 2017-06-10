public class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary){
            String key = getKey(s);
            if (map.containsKey(key)){
                if (!map.get(key).equals(s)){//two string have same key, invalid it.
                    map.put(key, "");
                }
            } else {
                map.put(key, s);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private String getKey(String word){
        if(word.length()<=2) return word;
        Integer length = word.length() - 2;
        return word.charAt(0) + length.toString() + word.charAt(word.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */