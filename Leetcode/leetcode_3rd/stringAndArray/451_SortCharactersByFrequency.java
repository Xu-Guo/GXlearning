/*
TLE
*/
public class Solution {
    public String frequencySort(String s) {
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, "" + c);
            } else {
                map.put(c, map.get(c) + c);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list, new Comparator<String>(){
           public int compare(String s1, String s2){
               return s2.length() - s1.length();
           } 
        });
        String res = "";
        for (int i = 0; i < list.size(); i++){
            res += list.get(i);
        }
        return res;
    }
}