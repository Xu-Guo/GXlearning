public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new LinkedList<>();
        }
        LinkedList<String> list = new LinkedList<>();//实际上是建立了新的队列
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//map nums to characters
        list.add("");//add a new string
        for(int i=0; i<digits.length(); i++){//go through all the digits
            int n = Character.getNumericValue(digits.charAt(i));//get curr digit
            while(list.peek().length() == i){//i stand for current level, if length > i, cur level is finished
                String s = list.poll();//get a string
                for(char c : map[n].toCharArray()){//bfs add new character at each result's end
                    list.add(s+c);
                }
            }
        }
        return list;
    }
}