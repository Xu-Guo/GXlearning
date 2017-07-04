public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();// K: hash, V: anagram list
        for (String str : strs){
            int[] dict = new int[26];
            for (char c : str.toCharArray()){
                dict[c - 'a']++;
            }
            int hash = getHash(dict);
            if (!map.containsKey(hash)){
                List<String> list = new ArrayList<>();
                map.put(hash, list);
            }
            map.get(hash).add(str);
        }
        for (List<String> list : map.values()){
            if (list.size() > 1){
                res.addAll(list);
            }
        }
        return res;
    }
    
    private int getHash(int[] dict){
        int hash = 0;
        int a = 19;
        int b = 37;
        for (int num : dict){
            hash = a * hash + num;
            a = a * b;
        }
        return hash;
    }
}