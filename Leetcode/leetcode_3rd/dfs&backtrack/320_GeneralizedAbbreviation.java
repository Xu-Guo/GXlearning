/*
We can use backtracking to solve this problem,
for each letter in a word, we can choose keep it or abbr it;
- to Keep it we finished prev abbrs by adding the count to the end of the path
- to abbr it, we move to next position and increase the count of abbrs

*/
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String word, int pos, String path, int count){
        if (pos == word.length()){//last letter has been processed
            if (count > 0){
                path += count;// if there is abbr left add to the end
            }
            res.add(path);
            return;
        }

        //abbr the cur letter, count of abbr + 1
        helper(res, word, pos + 1, path, count + 1);
        //keep the current letter, need to add the count of abbr in front the current letter
        helper(res, word, pos + 1, path + (count > 0 ? count : "") + word.charAt(pos), 0);
    }
}