//go through the String from index 1 left to right if we find two concecutive char with same value of '+', change them to '-' and added it to list 
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        
        if(s == null || s.length() < 2){
            return list;
        }
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                list.add(s.substring(0, i-1) + "--" + s.substring(i+1, s.length()));
            }
        }
        return list;
    }
}